package searching;

import helpers.ArrayHelpers;

public class MergeAndBinaryRoutines implements ISearchingSorting
{
    private int[] temp; //this is for the merge() routine

    @Override
    public boolean isSorted(int[] array)
    {
        return ArrayHelpers.isSorted(array);
    }

    @Override
    public void sort(int[] array)
    {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int low, int high)
    {
        temp = new int[array.length];

        for (int size = 1; size <= array.length - 1; size *= 2)
        {
            for (int left = 0; left < array.length - 1; left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, array.length - 1);

                merge(array, left, mid, right);
            }
        }
    }

    private void merge(int[] array, int low, int mid, int high)
    {
        int left = low;
        int right = mid + 1;
        int count = high - low + 1;

        for (int i = 0; i < count; i++)
        {
            if (left > mid)
            {
                temp[low + i] = array[right++];
            }
            else if (right > high)
            {
                temp[low + i] = array[left++];
            }
            else if (array[left] < array[right])
            {
                temp[low + i] = array[left++];
            }
            else if (array[left] >= array[right])
            {
                temp[low + i] = array[right++];
            }
        }

        for (int i = 0; i < count; i++)
        {
            array[low + i] = temp[low + i];
        }
    }

    @Override
    public boolean search(int[] array, int search)
    {
        return binarySearch(array, search) != -1;
    }

    private int binarySearch(int[] values, int search)
    {
        int low = 0;
        int high = values.length - 1;

        while (low <= high)
        {
            int mid = (high + low) / 2;

            if (values[mid] == search)
            {
                return mid;
            }
            else if (values[mid] < search)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
}
