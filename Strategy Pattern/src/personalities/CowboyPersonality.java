package personalities;

public class CowboyPersonality implements IPersonality
{
    @Override
    public void sayHi(String person)
    {
        System.out.println("Howdy, " + person + "!");
    }

    @Override
    public void sayGoodbye()
    {
        System.out.println("Bye, partner!");
    }
}
