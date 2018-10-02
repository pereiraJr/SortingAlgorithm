package sorting.algorithm;

public class MergeSort {
    private long numberOfLoops = 0;

    public void mergeSort(int[] v, int begin, int end) {
        if (begin < end) {
            numberOfLoops++;
            int middle = (begin + end) / 2;
            mergeSort(v, begin, middle);
            mergeSort(v, middle + 1, end);
            merge(v, begin, middle, end);
        }
    }

    public long getNumberOfLoops() {
        return numberOfLoops;
    }

    private void merge(int[] array, int begin, int middle, int end) {
        int[] helper = new int[array.length];
        for (int k = begin; k <= end; k++) {
            numberOfLoops++;
            helper[k] = array[k];
        }

        int i = begin;
        int j = middle + 1;

        for (int k = begin; k <= end; k++) {
            numberOfLoops++;
            if (i > middle) array[k] = helper[j++];
            else if (j > end) array[k] = helper[i++];
            else if (helper[i] < helper[j]) array[k] = helper[i++];
            else array[k] = helper[j++];
        }
    }
}


