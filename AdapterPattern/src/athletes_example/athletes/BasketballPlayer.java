package athletes_example.athletes;

public class BasketballPlayer
{
    private String lName;
    private String fName;
    private char middleInitial;
    private String team;
    private String stats;

    public BasketballPlayer(String lName, String fName, char middleInitial,
                            String team)
    {
        this.lName = lName;
        this.fName = fName;
        this.middleInitial = middleInitial;
        this.team = team;

        stats = "";
    }

    public void add(String stat, Object value)
    {
        if (!stats.isEmpty())
        {
            stats += ",";
        }
        stats += stat + ": " + value;
    }

    public String getlName()
    {
        return lName;
    }

    public String getfName()
    {
        return fName;
    }

    public char getMiddleInitial()
    {
        return middleInitial;
    }

    public String getTeam()
    {
        return team;
    }

    public String getStats()
    {
        return stats;
    }

    @Override
    public String toString()
    {
        return "BasketballPlayer{" +
                "lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", middleInitial=" + middleInitial +
                ", team='" + team + '\'' +
                ", stats='" + stats + '\'' +
                '}';
    }
}
