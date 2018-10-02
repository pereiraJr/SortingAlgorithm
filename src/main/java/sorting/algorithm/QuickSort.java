package sorting.algorithm;

public class QuickSort {
    private long numberOfLoops = 0;

    public long getNumberOfLoops() {
        return numberOfLoops;
    }

    public void quickSort(int[] array, int begin, int end) {
        // pick the pivot
        int middle = begin + (end - begin) / 2;
        int pivot = array[middle];
        int i = begin, j = end;

        while (i <= j) {
            numberOfLoops++;
            while (array[i] < pivot) {
                numberOfLoops++;
                i++;
            }
            while (array[j] > pivot) {
                numberOfLoops++;
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (begin < j)
            quickSort(array, begin, j);

        if (end > i)
            quickSort(array, i, end);
    }
}
