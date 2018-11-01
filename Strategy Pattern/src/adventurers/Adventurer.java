package adventurers;

import behaviors.IBehavior;

public abstract class Adventurer
{
    private String name;
    protected IBehavior behavior;

    public Adventurer(String name, IBehavior behavior)
    {
        this.name = name;
        this.behavior = behavior;
    }

    public void interact()
    {
        System.out.println("Hello, Sally!");
        behavior.act();
        System.out.println("Goodbye!");
    }
}
