package entities;

public class Message
{
    private String author;
    private String messageBody;

    public Message(String author, String messageBody)
    {
        this.author = author;
        this.messageBody = messageBody;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
    }

    @Override
    public String toString()
    {
        return "Message{" +
                "author='" + author + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
