package variations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IPAddressMultiton
{
    public static final int MAX_OCTET = 255;
    public static final int MIN_OCTET = 0;
    private int[] addressParts;

    private static Map<AddressType, IPAddressMultiton> instances;

    private IPAddressMultiton(int firstOctet, int secondOctet,
                       int thirdOctet, int fourthOctet)
    {
        rangeCheck(firstOctet, secondOctet, thirdOctet, fourthOctet);
        addressParts = new int[] {firstOctet, secondOctet, thirdOctet, fourthOctet};
    }

    private void rangeCheck(int... values)
    {
        for (int value : values)
        {
            rangeCheck(value);
        }
    }

    private void rangeCheck(int value)
    {
        if (value < MIN_OCTET || value > MAX_OCTET)
        {
            throw new IllegalArgumentException("Octet value outside range: [0, 255]");
        }
    }

    public static IPAddressMultiton getInstance(AddressType type)
    {
        //is this our first request?
        if (instances == null)
        {
            //create our map
            instances = new HashMap<>();

            //add our instances to the map
            instances.put(AddressType.LOCALHOST, new IPAddressMultiton(127, 0, 0, 1));
            instances.put(AddressType.SERVER, new IPAddressMultiton(69, 187, 0, 15));
            instances.put(AddressType.SERVICES_LAYER, new IPAddressMultiton(17, 0, 0, 0));
        }

        if (instances.containsKey(type))
        {
            return instances.get(type);
        }
        return null;
    }

    public int getFirstOctet()
    {
        return addressParts[0];
    }

    public int getSecondOctet()
    {
        return addressParts[1];
    }

    public int getThirdOctet()
    {
        return addressParts[2];
    }

    public int getFourthOctet()
    {
        return addressParts[3];
    }

    @Override
    public String toString()
    {
        return Arrays.toString(addressParts);
    }

    public enum AddressType
    {
        LOCALHOST,
        SERVER,
        SERVICES_LAYER
    }
}
