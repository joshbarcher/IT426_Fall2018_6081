package controller;

import javafx.scene.paint.Color;
import model.FileData;
import model.IColorsData;
import model.ColorPair;
import model.db.DBData;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class Controller
{
    private IColorsData model;

    public Controller()
    {
        model = new DBData(); //new FileData("files/colors.dat"); //new InMemoryData();
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
