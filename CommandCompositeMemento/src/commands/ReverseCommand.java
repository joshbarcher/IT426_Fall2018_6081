package commands;

import entities.Message;

public class ReverseCommand implements ICommand
{
    private Message receiver;

    private String oldMessage;

    public ReverseCommand(Message receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void doCommand()
    {
        oldMessage = receiver.getMessageBody();

        char[] characters = oldMessage.toCharArray();
        for (int i = 0; i < oldMessage.length() / 2; i++)
        {
            char temp = characters[i];
            characters[i] = characters[characters.length - 1 - i];
            characters[characters.length - 1 - i] = temp;
        }
        receiver.setMessageBody(new String(characters));
    }

    @Override
    public void undoCommand()
    {
        receiver.setMessageBody(oldMessage);
    }
}
