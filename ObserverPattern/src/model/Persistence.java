package model;

import observer.IObserver;
import observer.Observable;
import model.FruitData.Change;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Persistence implements IObserver
{
    @Override
    public void update(Observable observable, Object... args)
    {
        Change command = (Change)args[0];
        if (command != Change.RETRIEVE)
        {
            FruitData model = (FruitData)observable;
            try (PrintWriter writer = new PrintWriter(
                    new FileOutputStream("files/fruit.dat")))
            {
                for (Fruit fruit : model.getFruits())
                {
                    writer.println(fruit.toString());
                }
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Error writing to file: " + ex.getMessage());
            }
        }
    }
}
