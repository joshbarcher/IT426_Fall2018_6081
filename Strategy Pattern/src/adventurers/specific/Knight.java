package adventurers.specific;

import adventurers.TalkingAdventurer;
import behaviors.AngstyBehavior;
import personalities.IPersonality;

public class Knight extends TalkingAdventurer
{
    public Knight(String name, IPersonality personality)
    {
        super(name, new AngstyBehavior(), personality);
    }
}
