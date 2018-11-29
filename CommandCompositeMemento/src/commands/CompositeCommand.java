package commands;

public class CompositeCommand implements ICommand
{
    private ICommand[] commands;

    public CompositeCommand(ICommand... commands)
    {
        this.commands = commands;
    }

    @Override
    public void doCommand()
    {
        for (int i = 0; i < commands.length; i++)
        {
            commands[i].doCommand();
        }
    }

    @Override
    public void undoCommand()
    {
        for (int i = commands.length - 1; i >= 0; i--)
        {
            commands[i].undoCommand();
        }
    }
}
