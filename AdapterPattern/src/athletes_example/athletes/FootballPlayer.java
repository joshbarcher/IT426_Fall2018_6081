package athletes_example.athletes;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FootballPlayer
{
    private String fullName;
    private String team;
    private Map<String, Object> stats;

    public FootballPlayer(String fullName, String team)
    {
        this.fullName = fullName;
        this.team = team;

        stats = new TreeMap<>();
    }

    public void addStat(String name, Object value)
    {
        stats.put(name, value);
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getTeam()
    {
        return team;
    }

    public Map<String, Object> getStats()
    {
        return Collections.unmodifiableMap(stats);
    }

    @Override
    public String toString()
    {
        return "FootballPlayer{" +
                "fullName='" + fullName + '\'' +
                ", team='" + team + '\'' +
                ", stats=" + stats +
                '}';
    }
}
