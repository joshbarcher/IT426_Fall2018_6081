package colorsprogram.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InMemoryData implements IColorsData
{
    private Map<String, Color> colors;

    private static InMemoryData instance;

    private InMemoryData()
    {
        colors = new TreeMap<>();
    }

    public static InMemoryData getInstance()
    {
        if (instance == null)
        {
            instance = new InMemoryData();
        }

        return instance;
    }

    @Override
    public void addColor(String name, Color color)
    {
        if (!colors.containsKey(name))
        {
            colors.put(name, color);
        }
    }

    @Override
    public void removeColor(String name)
    {
        colors.remove(name);
    }

    @Override
    public void update(String name, Color color)
    {
        if (colors.containsKey(name))
        {
            colors.put(name, color);
        }
    }

    @Override
    public List<ColorPair> getColors()
    {
        List<ColorPair> pairs = new ArrayList<>();

        for (String name : colors.keySet())
        {
            pairs.add(new ColorPair(name, colors.get(name)));
        }

        return pairs;
    }
}
