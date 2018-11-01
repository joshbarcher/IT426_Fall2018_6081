package adventurers;

import behaviors.IBehavior;
import personalities.IPersonality;

public abstract class TalkingAdventurer extends Adventurer
{
    private IPersonality personality;

    public TalkingAdventurer(String name, IBehavior behavior,
                             IPersonality personality)
    {
        super(name, behavior);
        this.personality = personality;
    }

    @Override
    public void interact()
    {
        personality.sayHi("Sally");
        behavior.act();
        personality.sayGoodbye();
    }
}
