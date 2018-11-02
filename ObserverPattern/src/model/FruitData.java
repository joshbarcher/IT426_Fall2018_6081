package model;

import observer.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FruitData extends Observable
{
    private List<Fruit> fruits;

    public FruitData()
    {
        fruits = new ArrayList<>();
    }

    //CRUD ACCESS
    public void addFruit(Fruit fruit)
    {
        fruits.add(fruit);

        //let observers know that we added a new fruit
        notifyObservers(Change.ADD, fruit);
    }

    public void removeFruit(UUID id)
    {
        boolean removedAFruit = false;
        for (int i = fruits.size() - 1; i >= 0; i--)
        {
            if (id.equals(fruits.get(i).getId()))
            {
                fruits.remove(i);
                removedAFruit = true;
            }
        }

        if (removedAFruit)
        {
            notifyObservers(Change.REMOVE);
        }
    }

    public List<Fruit> getFruits()
    {
        return Collections.unmodifiableList(fruits);
    }

    public void updateFruit(UUID id, String type, boolean fresh)
    {
        boolean updatedFruit = false;
        for (int i = 0; i < fruits.size(); i++)
        {
            Fruit check = fruits.get(i);
            if (id.equals(check.getId()))
            {
                check.setType(type);
                check.setFresh(fresh);
                updatedFruit = true;
            }
        }

        if (updatedFruit)
        {
            notifyObservers(Change.UPDATE);
        }
    }

    public enum Change
    {
        ADD,
        REMOVE,
        UPDATE,
        RETRIEVE
    }
}