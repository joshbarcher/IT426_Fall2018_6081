package singleton;

public class Airplane
{
    private String model;
    private int yearsInService;
    private int seats;

    //store our singleton object
    private static Airplane instance;

    private Airplane(String model, int yearsInService, int seats)
    {
        this.model = model;
        this.yearsInService = yearsInService;
        this.seats = seats;
    }

    public static Airplane getInstance()
    {
        if (instance == null)
        {
            instance = new Airplane("Boeing 747", 8, 60);
        }
        return instance;
    }

    public String getModel()
    {
        return model;
    }

    public int getYearsInService()
    {
        return yearsInService;
    }

    public int getSeats()
    {
        return seats;
    }

    @Override
    public String toString()
    {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", yearsInService=" + yearsInService +
                ", seats=" + seats +
                '}';
    }
}
