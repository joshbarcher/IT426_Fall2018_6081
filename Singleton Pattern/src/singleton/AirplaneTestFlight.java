package singleton;

public class AirplaneTestFlight
{
    public static void main(String[] args)
    {
        //Airplane plane = new Airplane("Boeing 747", 8, 60);

        Airplane plane1 = Airplane.getInstance();
        System.out.println(plane1);

        Airplane plane2 = Airplane.getInstance();
        System.out.println(plane2);

        //compare memory addresses
        System.out.println(plane1 == plane2);
    }
}
