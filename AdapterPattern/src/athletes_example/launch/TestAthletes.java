package athletes_example.launch;

import athletes_example.adapters.FootballAdapter;
import athletes_example.athletes.FootballPlayer;
import athletes_example.news.SportsNews;

public class TestAthletes
{
    public static void main(String[] args)
    {
        FootballPlayer marshawn = new FootballPlayer("Marshawn Lynch",
                "Oakland Raiders");
        marshawn.addStat("running yards", 500);
        marshawn.addStat("fumbles", 5);

        SportsNews news = new SportsNews(new FootballAdapter(marshawn));
        news.printSportsSummary();
    }
}
