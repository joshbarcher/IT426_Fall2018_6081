package personalities;

public class FormalPersonality implements IPersonality
{
    @Override
    public void sayHi(String person)
    {
        System.out.println("Good evening, " + person);
    }

    @Override
    public void sayGoodbye()
    {
        System.out.println("Best wishes...");
    }
}
