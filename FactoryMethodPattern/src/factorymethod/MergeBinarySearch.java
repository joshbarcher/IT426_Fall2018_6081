package factorymethod;

import searching.ISearchingSorting;
import searching.MergeAndBinaryRoutines;

public class MergeBinarySearch extends Searching
{
    public MergeBinarySearch(int[] searchSpace)
    {
        super(searchSpace);
    }

    @Override
    public ISearchingSorting getRoutines()
    {
        return new MergeAndBinaryRoutines();
    }
}
