package athletes_example.adapters;

import athletes_example.athletes.FootballPlayer;
import athletes_example.news.IAthlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FootballAdapter implements IAthlete
{
    //store the adaptee
    private FootballPlayer player;

    public FootballAdapter(FootballPlayer player)
    {
        this.player = player;
    }

    @Override
    public String provideFullName()
    {
        return player.getFullName();
    }

    @Override
    public String provideTeam()
    {
        return player.getTeam();
    }

    @Override
    public List<String> provideStats()
    {
        Map<String, Object> stats = player.getStats();
        List<String> compatibleStats = new ArrayList<>();

        //move elements from stats to compatibleStats
        for (String key : stats.keySet())
        {
            compatibleStats.add(key + ": " + stats.get(key));
        }

        return compatibleStats;
    }
}
