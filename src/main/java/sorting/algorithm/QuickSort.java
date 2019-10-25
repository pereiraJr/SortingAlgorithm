package sorting.algorithm;

public class QuickSort {
    private long counterOfLoops = 0;

    public long getCounterOfLoops() {
        return counterOfLoops;
    }

    public void quickSort(int[] array, int begin, int end) {
        // pick the pivot
        int middle = begin + (end - begin) / 2;
        int pivot = array[middle];
        int i = begin, j = end;

        while (i <= j) {
            counterOfLoops++;
            while (array[i] < pivot) {
                counterOfLoops++;
                i++;
            }
            while (array[j] > pivot) {
                counterOfLoops++;
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
