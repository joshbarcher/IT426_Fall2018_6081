package controller;

import model.Fruit;
import model.FruitData;
import model.Persistence;
import view.FruitStandUI;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FruitController
{
    private FruitData model;
    private Persistence persistence;

    public FruitController(FruitStandUI view)
    {
        model = new FruitData();
        persistence = new Persistence();

        model.addObserver(view);
        model.addObserver(persistence);
    }

    public void addFruit(String type, String fresh)
    {
        model.addFruit(new Fruit(type, Boolean.parseBoolean(fresh)));
    }

    public void removeFruit(UUID id)
    {
        model.removeFruit(id);
    }

    public List getFruits()
    {
        return model.getFruits();
    }

    public void updateFruit(UUID id, String type, boolean fresh)
    {
        model.updateFruit(id, type, fresh);
    }
}