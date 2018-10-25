package variations;

import java.util.Arrays;

public class IPAddressThreadSafe
{
    public static final int MAX_OCTET = 255;
    public static final int MIN_OCTET = 0;
    private int[] addressParts;

    private static IPAddressThreadSafe instance;

    private IPAddressThreadSafe(int firstOctet, int secondOctet,
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

    public static IPAddressThreadSafe getInstance()
    {
        if (instance == null)
        {
            synchronized (IPAddressThreadSafe.class)
            {
                if (instance == null)
                {
                    instance = new IPAddressThreadSafe(127, 0, 0, 1);
                }
            }
        }
        return instance;
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
}
