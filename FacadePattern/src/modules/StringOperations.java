package modules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringOperations
{
    public static String[] removeDuplicates(String[] values)
    {
        Set<String> set = new HashSet<>();

        for (String value : values)
        {
            set.add(value);
        }

        return set.toArray(new String[set.size()]);
    }

    public static String[] resize(String[] values, int newLength)
    {
        if (newLength <= 0)
        {
            throw new IllegalArgumentException("new length " + newLength + " must be positive!");
        }

        String[] newValues = new String[newLength];

        int elementsToCopy = Math.min(values.length, newValues.length);
        for (int i = 0; i < elementsToCopy; i++)
        {
            newValues[i] = values[i];
        }

        return newValues;
    }

    public static String[] filter(String[] values, String search)
    {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
        {
            if (!values[i].equals(search))
            {
                list.add(values[i]);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}