package personalities;

public class MutteringPersonality implements IPersonality
{
    @Override
    public void sayHi(String person)
    {
        System.out.println("hell... " + person.toLowerCase() + " ...");
    }

    @Override
    public void sayGoodbye()
    {
        System.out.println("See y...");
    }
}
