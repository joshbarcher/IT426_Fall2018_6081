package searching;

import helpers.ArrayHelpers;

import java.lang.reflect.Array;

public class InsertionAndInterpolationRoutines implements ISearchingSorting
{
    @Override
    public boolean isSorted(int[] array)
    {
        return ArrayHelpers.isSorted(array);
    }

    @Override
    public void sort(int[] array)
    {
        insertionSort(array);
    }

    private void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            for (int j = i; j >= 1; j--)
            {
                if (array[j] < array[j - 1])
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    break;
                }
            }
        }
    }

    private void swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public boolean search(int[] array, int search)
    {
        return interpolationSearch(array, search) != -1;
    }

    private int interpolationSearch(int[] values, int search)
    {
        int low = 0;
        int high = values.length - 1;

        while (values[low] <= search && values[high] >= search)
        {
            int mid = low + ((search - values[low]) *
                    (high - low)) / (values[high] - values[low]);

            if (values[mid] == search)
            {
                return mid;
            }
            else if (values[mid] < search)
            {
                low = mid + 1;
            }
            else //if (values[mid] > search)
            {
                high = mid - 1;
            }
        }

        if (values[low] == search)
        {
            return low;
        }
        else
        {
            return -1;
        }
    }
}
