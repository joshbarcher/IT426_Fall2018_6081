package athletes_example.athletes;

public class PickleballPlayer
{
    private String lastName;
    private String firstName;
    private String team;

    //stats
    private int forehand;
    private int backhand;
    private int aces;

    public PickleballPlayer(String lastName, String firstName,
                            String team, int forehand, int backhand, int aces)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.team = team;
        this.forehand = forehand;
        this.backhand = backhand;
        this.aces = aces;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getTeam()
    {
        return team;
    }

    public int getForehand()
    {
        return forehand;
    }

    public int getBackhand()
    {
        return backhand;
    }

    public int getAces()
    {
        return aces;
    }

    @Override
    public String toString()
    {
        return "PickleballPlayer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", team='" + team + '\'' +
                ", forehand=" + forehand +
                ", backhand=" + backhand +
                ", aces=" + aces +
                '}';
    }
}
