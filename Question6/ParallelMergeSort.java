package Question6;// Task 6
// Write a Java program that uses multithreading to implement a parallel merge sort algorithm. Your program should
// meet the following requirements:
// 1. Input: Your program should accept an array of integers as input.
// 2. Output: Your program should output the sorted array.
// 3. Algorithm: Your program should use a parallel merge sort algorithm to sort the input array. The algorithm
// should divide the input array into subarrays, sort the subarrays in parallel using multiple threads, and then
// merge the sorted subarrays to produce the final sorted array.
// 4. Performance: Your program should be optimized for performance, such that it sorts the input array as
// quickly as possible. You should experiment with different thread counts and input array sizes to find the
// optimal settings.
// 5. Error handling: Your program should handle errors and exceptions gracefully, such as by providing
// informative error messages and exiting gracefully.
// 6. Testing: Your program should be thoroughly tested to ensure that it correctly sorts the input array and
// produces the expected output.
// To complete this assignment, you will need to implement the parallel merge sort algorithm in Java using
// multithreading. You should also experiment with different thread counts and input array sizes to find the optimal
// settings for performance. You can use Java's built-in threading and synchronization features, such as the Thread
// class and synchronized keyword, to implement the parallel merge sort algorithm.


// Import necessary libraries
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

// Main class for parallel merge sort implementation
public class ParallelMergeSort {

    // Nested class for the merge sort task (RecursiveAction subclass)
    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        // Constructor for the MergeSortTask
        public MergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            // Base case: if the subarray size is small enough, return
            if (end - start <= 1) {
                return;
            }

            // Calculate the midpoint
            int mid = (start + end) / 2;

            // Create tasks for the left and right subarrays
            MergeSortTask leftTask = new MergeSortTask(array, start, mid);
            MergeSortTask rightTask = new MergeSortTask(array, mid, end);

            // Invoke both tasks in parallel
            invokeAll(leftTask, rightTask);

            // Merge the sorted subarrays
            merge(array, start, mid, end);
        }

        // Merge two sorted subarrays
        private void merge(int[] array, int start, int mid, int end) {
            int[] merged = new int[end - start];
            int leftIndex = start;
            int rightIndex = mid;
            int mergedIndex = 0;

            // Compare and merge elements from the left and right subarrays
            while (leftIndex < mid && rightIndex < end) {
                if (array[leftIndex] < array[rightIndex]) {
                    merged[mergedIndex++] = array[leftIndex++];
                } else {
                    merged[mergedIndex++] = array[rightIndex++];
                }
            }

            // Copy remaining elements from the left subarray
            while (leftIndex < mid) {
                merged[mergedIndex++] = array[leftIndex++];
            }

            // Copy remaining elements from the right subarray
            while (rightIndex < end) {
                merged[mergedIndex++] = array[rightIndex++];
            }

            // Copy the merged elements back to the original array
            System.arraycopy(merged, 0, array, start, merged.length);
        }
    }

    // Method to perform parallel merge sort
    public static void parallelMergeSort(int[] array) {
        // Create a ForkJoinPool for parallel execution
        ForkJoinPool pool = new ForkJoinPool();

        // Create a MergeSortTask for the entire array and invoke it
        MergeSortTask task = new MergeSortTask(array, 0, array.length);
        pool.invoke(task);
    }

    // Main method to test parallel merge sort
    public static void main(String[] args) {
        // Input array to be sorted
        int[] inputArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};

        // Perform parallel merge sort on the input array
        parallelMergeSort(inputArray);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(inputArray));
    }
}
