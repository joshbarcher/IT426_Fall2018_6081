package commands;

import entities.Message;

public class EditMessageCommand implements ICommand
{
    private Message receiver;
    private String newMessageBody;
    private String oldMessageBody;

    public EditMessageCommand(Message receiver, String newMessageBody)
    {
        this.receiver = receiver;
        this.newMessageBody = newMessageBody;
    }

    @Override
    public void doCommand()
    {
        if (oldMessageBody == null)
        {
            oldMessageBody = receiver.getMessageBody();
        }
        receiver.setMessageBody(newMessageBody);
    }

    @Override
    public void undoCommand()
    {
        receiver.setMessageBody(oldMessageBody);
    }
}
