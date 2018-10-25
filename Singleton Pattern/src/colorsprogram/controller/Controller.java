package colorsprogram.controller;

import colorsprogram.model.ColorPair;
import colorsprogram.model.IColorsData;
import colorsprogram.model.db.DBData;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class Controller
{
    private IColorsData model;

    private static Controller instance;

    private Controller()
    {
        model = DBData.getInstance(); //new FileData("files/colors.dat"); //new InMemoryData();
    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }

        return instance;
    }

    private String getPath(String file)
    {
        try
        {
            return new File(file).toURI().toURL().toString();
        }
        catch (MalformedURLException ex)
        {
            throw new IllegalStateException("File not found");
        }
    }

    public boolean handleNewColor(String name, Color color)
    {
        if (isEmpty(name) || color == null)
        {
            return false;
        }

        model.addColor(name, color);
        return true;
    }

    private boolean isEmpty(String value)
    {
        return value == null || value.equals("");
    }

    public List<ColorPair> handleGetColors()
    {
        return model.getColors();
    }
}
