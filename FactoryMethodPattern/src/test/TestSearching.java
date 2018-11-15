package test;

import factorymethod.InsertionInterpolationSearch;
import factorymethod.Searching;

public class TestSearching
{
    public static void main(String[] args)
    {
        int[] array = {42, 47, 5000, 6, -10, 98, -0, 12, 16};
        Searching searching = new InsertionInterpolationSearch(array); //new MergeBinarySearch(array);

        System.out.println(searching.contains(0));
        System.out.println(searching.contains(98));
        System.out.println(searching.contains(10));
    }
}
