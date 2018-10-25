package variations;

import variations.IPAddressMultiton.AddressType;

public class TestVariations
{
    public static void main(String[] args)
    {
        IPAddressMultiton address = IPAddressMultiton.getInstance(AddressType.LOCALHOST);
        System.out.println(address == IPAddressMultiton.getInstance(AddressType.LOCALHOST));

        System.out.println(address);
        IPAddressMultiton otherAddress = IPAddressMultiton.getInstance(AddressType.SERVICES_LAYER);
        System.out.println(otherAddress);
    }
}
