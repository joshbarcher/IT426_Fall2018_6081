package colorsprogram.model;

import javafx.scene.paint.Color;

import java.util.List;

public interface IColorsData
{
    void addColor(String name, Color color);
    void removeColor(String name);
    void update(String name, Color color);
    public List<ColorPair> getColors();
}
