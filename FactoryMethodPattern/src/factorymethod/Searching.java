package factorymethod;

import searching.ISearchingSorting;

public abstract class Searching
{
    private int[] searchSpace;

    public Searching(int[] searchSpace)
    {
        this.searchSpace = searchSpace;
    }

    public boolean contains(int search)
    {
        ISearchingSorting searchingSorting = getRoutines();

        //is this a sorted array (hopefully)
        if (!searchingSorting.isSorted(searchSpace))
        {
            searchingSorting.sort(searchSpace);
        }

        return searchingSorting.search(searchSpace, search);
    }

    public abstract ISearchingSorting getRoutines();
}
