package adventurers.specific;

import adventurers.TalkingAdventurer;
import behaviors.IBehavior;
import behaviors.SkittishBehavior;
import personalities.IPersonality;

public class Princess extends TalkingAdventurer
{
    public Princess(String name, IPersonality personality)
    {
        super(name, new SkittishBehavior(), personality);
    }
}
