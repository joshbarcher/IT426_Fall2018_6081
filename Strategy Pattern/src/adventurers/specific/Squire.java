package adventurers.specific;

import adventurers.TalkingAdventurer;
import behaviors.ClingyBehavior;
import personalities.MutteringPersonality;

public class Squire extends TalkingAdventurer
{
    public Squire(String name)
    {
        super(name, new ClingyBehavior(), new MutteringPersonality());
    }
}
