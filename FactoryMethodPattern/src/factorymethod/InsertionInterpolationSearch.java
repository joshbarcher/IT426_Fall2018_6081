package factorymethod;

import searching.ISearchingSorting;
import searching.InsertionAndInterpolationRoutines;

public class InsertionInterpolationSearch extends Searching
{
    public InsertionInterpolationSearch(int[] searchSpace)
    {
        super(searchSpace);
    }

    @Override
    public ISearchingSorting getRoutines()
    {
        return new InsertionAndInterpolationRoutines();
    }
}
