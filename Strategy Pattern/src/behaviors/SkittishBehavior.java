package behaviors;

public class SkittishBehavior implements IBehavior
{
    @Override
    public void act()
    {
        System.out.println("I'm not going down that alley, yikes!");
    }
}
