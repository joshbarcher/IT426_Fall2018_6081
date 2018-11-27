package commands;

import entities.Message;

public class AbbreviateCommand implements ICommand
{
    private Message receiver;
    private int length;

    //save the old message
    private String oldMessageBody;

    public AbbreviateCommand(Message receiver, int length)
    {
        this.receiver = receiver;
        this.length = length;
    }

    @Override
    public void doCommand()
    {
        oldMessageBody = receiver.getMessageBody();
        receiver.setMessageBody(oldMessageBody.substring(0, length) + "...");
    }

    @Override
    public void undoCommand()
    {
        receiver.setMessageBody(oldMessageBody);
    }
}
