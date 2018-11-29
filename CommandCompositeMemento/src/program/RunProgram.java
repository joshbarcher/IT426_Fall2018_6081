package program;

import commands.*;
import entities.Message;

import java.util.Arrays;
import java.util.List;

public class RunProgram
{
    public static void main(String[] args)
    {
        Message message = new Message("Bill Gates", "Microsoft will change the world!");

        ICommand composite = new CompositeCommand(
                new EditMessageCommand(message, "Github is ours, mwahahahaha!"),
                new AbbreviateCommand(message, 10)
        );


        ICommand reverse = new ReverseCommand(message);
        ICommand commands = new CompositeCommand(composite, reverse);

        System.out.println("Before: " + message.toString());
        commands.doCommand();
        System.out.println("After: " + message.toString());

        commands.undoCommand();
        System.out.println("Undo: " + message.toString());
        commands.doCommand();
        System.out.println("Redo: " + message.toString());
    }

    private static void testCommands()
    {
        Message message = new Message("Bill Gates", "Microsoft will change the world!");
        ICommand abbreviate = new AbbreviateCommand(message, 10);
        ICommand edit = new EditMessageCommand(message, "Github is ours, mwahahahaha!");

        //group together our commands (track history, log our history, undo, redo)
        List<ICommand> commands = Arrays.asList(edit, abbreviate);

        System.out.println("Before: " + message.toString());
        for (int i = 0; i < commands.size(); i++)
        {
            commands.get(i).doCommand();
        }
        System.out.println("After: " + message.toString());

        for (int i = commands.size() - 1; i >= 0; i--)
        {
            commands.get(i).undoCommand();
        }
        System.out.println("After undo all: " + message.toString());

        //try undo/redo
        /*abbreviate.undoCommand();
        System.out.println("Undo: " + message.toString());
        abbreviate.doCommand();
        System.out.println("Redo: " + message.toString());*/
    }
}
