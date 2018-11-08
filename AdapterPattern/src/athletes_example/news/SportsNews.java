package athletes_example.news;

import java.util.Arrays;
import java.util.List;

public class SportsNews
{
    private List<IAthlete> allAthletes;

    public SportsNews(IAthlete... athletes)
    {
        allAthletes = Arrays.asList(athletes);
    }

    public void printSportsSummary()
    {
        for (IAthlete athlete : allAthletes)
        {
            printAthlete(athlete);
        }
    }

    private void printAthlete(IAthlete athlete)
    {
        //print the name, team and stats
        System.out.println("Name: " + athlete.provideFullName());
        System.out.println("Team: " + athlete.provideTeam());
        System.out.println("**************");

        for (String stat : athlete.provideStats())
        {
            System.out.println(stat);
        }
        System.out.println();
    }
}
