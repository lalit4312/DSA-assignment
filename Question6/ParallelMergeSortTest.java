package Question6;

import Question6.ParallelMergeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ParallelMergeSortTest {
    @Test
    public void testParallelMergeSort() {
        int[] inputArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ParallelMergeSort.parallelMergeSort(inputArray);
        assertArrayEquals(expectedSortedArray, inputArray);
    }
}
