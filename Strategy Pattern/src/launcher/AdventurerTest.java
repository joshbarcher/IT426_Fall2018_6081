package launcher;

import adventurers.Adventurer;
import adventurers.TalkingAdventurer;
import adventurers.specific.Knight;
import adventurers.specific.Princess;
import adventurers.specific.Squire;
import behaviors.AngstyBehavior;
import behaviors.ClingyBehavior;
import behaviors.SkittishBehavior;
import personalities.CowboyPersonality;
import personalities.FormalPersonality;
import personalities.MutteringPersonality;

public class AdventurerTest
{
    public static void main(String[] args)
    {
        /*Adventurer knight = new Adventurer("Fernand", new ClingyBehavior());
        knight.interact();

        Adventurer anotherKnight = new Adventurer("Erza", new AngstyBehavior());
        anotherKnight.interact();

        TalkingAdventurer princess = new TalkingAdventurer("Peach", new SkittishBehavior(),
                new FormalPersonality());
        princess.interact();

        TalkingAdventurer squire = new TalkingAdventurer("Bertrand", new ClingyBehavior(),
                new MutteringPersonality());*/

        TalkingAdventurer oswald = new Knight("Oswald", new CowboyPersonality());
        TalkingAdventurer zelda = new Princess("Zelda", new FormalPersonality());
        TalkingAdventurer link = new Squire("Link");

        oswald.interact();
        zelda.interact();
        link.interact();
    }
}
