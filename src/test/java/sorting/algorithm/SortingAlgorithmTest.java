package sorting.algorithm;

import factory.ArrayFactory;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortingAlgorithmTest {
    @Rule
    public TestName name = new TestName();

    private static int[] SORTED_ARRAY_TO_MERGESORT;
    private static int[] SORTED_ARRAY_TO_QUICKSORT;
    private static int[] SORTED_ARRAY_TO_INSERTIONSORT;
    private int[] ORDERED_ARRAY = {1, 2, 3, 4, 5, 8, 9};

    //Controlled Variables
    private int[] DEFAULT_ARRAY_TO_QUICKSORT = {1, 2, 4, 3, 5, 9, 8};
    private int[] DEFAULT_ARRAY_TO_MERGESORT = {1, 2, 4, 3, 5, 9, 8};
    private int[] DEFAULT_ARRAY_TO_INSERTIONSORT = {1, 2, 4, 3, 5, 9, 8};

    private static QuickSort quickSort;
    private static InsertionSort insertionSort;
    private static MergeSort mergeSort;

    @BeforeClass
    public static void setUp() throws Exception {
        quickSort = new QuickSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        SORTED_ARRAY_TO_MERGESORT = ArrayFactory.intArray(900000, 1000);
        SORTED_ARRAY_TO_QUICKSORT = SORTED_ARRAY_TO_MERGESORT.clone();
        SORTED_ARRAY_TO_INSERTIONSORT = SORTED_ARRAY_TO_MERGESORT.clone();
    }

    @Test
    public void arraysToQuickSortMergeSortAndInsertionSortShouldBeEqual() {
        assertArrayEquals(SORTED_ARRAY_TO_MERGESORT, SORTED_ARRAY_TO_QUICKSORT);
        assertArrayEquals(SORTED_ARRAY_TO_INSERTIONSORT, SORTED_ARRAY_TO_MERGESORT);
    }

    @Test
    public void shouldOrderArrayUsingMergeSort() {
        mergeSort.mergeSort(DEFAULT_ARRAY_TO_MERGESORT, 0, DEFAULT_ARRAY_TO_MERGESORT.length - 1);
        assertEquals(Arrays.toString(ORDERED_ARRAY), Arrays.toString(DEFAULT_ARRAY_TO_MERGESORT));
    }

    @Test
    public void shouldOrderArrayWithQuickSort() {
        quickSort.quickSort(DEFAULT_ARRAY_TO_QUICKSORT, 0, DEFAULT_ARRAY_TO_QUICKSORT.length - 1);
        assertEquals(Arrays.toString(ORDERED_ARRAY), Arrays.toString(DEFAULT_ARRAY_TO_QUICKSORT));
    }

    @Test
    public void shouldOrderArrayUsingInsertionSort() {
        insertionSort.sort(DEFAULT_ARRAY_TO_INSERTIONSORT);
        assertEquals(Arrays.toString(ORDERED_ARRAY), Arrays.toString(DEFAULT_ARRAY_TO_INSERTIONSORT));
    }

    @Test
    public void shouldGetDurationTimeUsingMergeSort() {
        mergeSort.mergeSort(SORTED_ARRAY_TO_MERGESORT, 0, SORTED_ARRAY_TO_MERGESORT.length - 1);
        System.out.println("Number of Loops Merge Sort: \t" + mergeSort.getNumberOfLoops());
    }

    @Test
    public void shouldGetDurationTimeUsingQuickSort() {
        quickSort.quickSort(SORTED_ARRAY_TO_QUICKSORT, 0, SORTED_ARRAY_TO_QUICKSORT.length - 1);
        System.out.println("Number of Loops Quick Sort: \t" + quickSort.getNumberOfLoops());
    }

    @Test
    public void shouldGetDurationTimeUsingInsertionSort() {
        insertionSort.sort(SORTED_ARRAY_TO_INSERTIONSORT);
        System.out.println("Number of Loops Insertion Sort: " + insertionSort.getNumberOfLoops());
    }

    @After
    public void tearDown() throws Exception {
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in [" + name.getMethodName() + "] bytes: " + memory);
    }
}
