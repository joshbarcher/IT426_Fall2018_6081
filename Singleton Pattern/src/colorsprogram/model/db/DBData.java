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

    private static DBData instance;

    private DBData()
    {
        try
        {
            //get connected to the database
            conn = DriverManager.getConnection("jdbc:sqlite:colorsDb.sqlite");
            Class.forName("org.sqlite.JDBC"); //fix our project path
            System.out.println("Connected to ColorsDb");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            //rethrow our exception if we cannot connect
            throw new IllegalStateException("Cannot connect to model.db: " + e.getMessage());
        }
    }

    public static DBData getInstance()
    {
        if (instance == null)
        {
            instance = new DBData();
        }
        return instance;
    }

    @Override
    public void addColor(String name, Color color)
    {
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO colors VALUES(null, " +
                    color.getRed() + ", " +
                    color.getGreen() + ", " +
                    color.getBlue() + ", " +
                    color.getOpacity() + ", '" +
                    name + "')");
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Cannot insert color: " + e.getMessage());
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
        //we use a ResultSet object to iterate over rows in a DB using JDBC
        try
        {
            ResultSet results = conn.createStatement().executeQuery(
                    "SELECT name, red, green, blue, alpha FROM colors");

            List<ColorPair> pairs = new ArrayList<>();
            while (results.next()) //move to the next row and return true if successful
            {
                String name = results.getString("name");
                Color color = Color.color(
                    results.getDouble("red"),
                    results.getDouble("green"),
                    results.getDouble("blue"),
                    results.getDouble("alpha")
                );

                pairs.add(new ColorPair(name, color));
            }

            return pairs;
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Cannot retrieve colors: " + e.getMessage());
        }
    }
}
