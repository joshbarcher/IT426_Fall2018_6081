package colorsprogram.model.db;

import colorsprogram.model.ColorPair;
import colorsprogram.model.IColorsData;
import javafx.scene.paint.Color;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBData implements IColorsData
{
    private Connection conn;

    public DBData()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:colorsDb.sqlite");

            //JDBC quirk
            Class.forName("org.sqlite.JDBC"); //fix our project classpath
            System.out.println("Connected to DB");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new IllegalStateException(
                    "Cannot connect to DB: " + e.getMessage());
        }
    }

    @Override
    public void addColor(String name, Color color)
    {
        try
        {
            Statement stmt = conn.createStatement();

            //execute() is for insert, update or delete
            stmt.execute("INSERT INTO colors VALUES (null, '" + name + "', " +
                          color.getRed() + ", " +
                          color.getGreen() + ", " +
                          color.getBlue() + ", " +
                          color.getOpacity() + ")");
        }
        catch (SQLException e)
        {
            throw new IllegalStateException(
                    "Error inserting new color: " + e.getMessage());
        }
    }

    @Override
    public void removeColor(String name)
    {
        //TODO ...
    }

    @Override
    public void update(String name, Color color)
    {
        //TODO ...
    }

    @Override
    public List<ColorPair> getColors()
    {
        try
        {
            ResultSet results = conn.createStatement().executeQuery(
                    "SELECT name, red, green, blue, alpha FROM colors");

            List<ColorPair> pairs = new ArrayList<>();
            while (results.next())
            {
                String name = results.getString("name");
                double red = results.getDouble("red");
                double green = results.getDouble("green");
                double blue = results.getDouble("blue");
                double alpha = results.getDouble("alpha");

                Color color = Color.color(red, green, blue, alpha);

                pairs.add(new ColorPair(name, color));
            }

            return pairs;
        }
        catch (SQLException e)
        {
            throw new IllegalStateException(
                    "Error retrieving colors: " + e.getMessage());
        }
    }
}
