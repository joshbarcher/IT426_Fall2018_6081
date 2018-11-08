package athletes_example.news;

import java.util.List;

public interface IAthlete
{
    String provideFullName();
    String provideTeam();
    List<String> provideStats();
}
