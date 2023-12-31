package Question3;
// 3.
//b) Implement bellman ford algorithm and priority queue using maximum heap
// Import necessary libraries
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

// Define a class to store edge information
class Edge {
    int source, destination, weight;

    // Constructor for Question3.Edge class
    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// Main class for Bellman-Ford algorithm
public class BellmanFord {
    private int vertices, edges;
    private List<Edge> edgeList;

    // Constructor for Question3.BellmanFord class
    public BellmanFord(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.edgeList = new ArrayList<>();
    }

    // Method to add an edge to the list of edges
    void addEdge(int source, int destination, int weight) {
        edgeList.add(new Edge(source, destination, weight));
    }

    // Bellman-Ford algorithm to find shortest paths
    void bellmanFord(int source) {
        // Initialize an array to store distances
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relaxation step: Run (V-1) iterations to find shortest paths
        for (int i = 1; i < vertices; ++i) {
            for (Edge edge : edgeList) {
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edgeList) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        // Printing shortest distances
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < vertices; ++i) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }
}

// Implementation of Question3.MaxHeapPriorityQueue
public class MaxHeapPriorityQueue {
    private List<Integer> heap;

    // Constructor for Question3.MaxHeapPriorityQueue class
    MaxHeapPriorityQueue() {
        heap = new ArrayList<>();
    }

    // Method to insert a value into the max-heap
    void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;

        // Maintain max-heap property by swapping with parent
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parentIndex)) {
            Collections.swap(heap, currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    // Method to extract the maximum value from the max-heap
    int extractMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }

        int maxValue = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        int currentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        // Restore max-heap property after removing root
        while (leftChildIndex < heap.size()) {
            int largestIndex = currentIndex;

            if (heap.get(leftChildIndex) > heap.get(largestIndex)) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestIndex)) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex == currentIndex) {
                break;
            }

            Collections.swap(heap, currentIndex, largestIndex);
            currentIndex = largestIndex;
            leftChildIndex = 2 * currentIndex + 1;
            rightChildIndex = 2 * currentIndex + 2;
        }

        return maxValue;
    }

    // Method to check if the max-heap is empty
    boolean isEmpty() {
        return heap.isEmpty();
    }
}

// Main class for testing Bellman-Ford algorithm and Question3.MaxHeapPriorityQueue
public class BelmanandHeap {

    public static void main(String[] args) {
        // Define the number of vertices and edges
        int vertices = 5;
        int edges = 8;

        // Create an instance of Question3.BellmanFord class and add edges
        BellmanFord bellmanFord = new BellmanFord(vertices, edges);
        bellmanFord.addEdge(0, 1, -1);
        bellmanFord.addEdge(0, 2, 4);
        bellmanFord.addEdge(1, 2, 3);
        bellmanFord.addEdge(1, 3, 2);
        bellmanFord.addEdge(1, 4, 2);
        bellmanFord.addEdge(3, 2, 5);
        bellmanFord.addEdge(3, 1, 1);
        bellmanFord.addEdge(4, 3, -3);

        int sourceVertex = 0;
        // Apply Bellman-Ford algorithm to find shortest paths
        bellmanFord.bellmanFord(sourceVertex);

        // Create an instance of Question3.MaxHeapPriorityQueue and insert elements
        MaxHeapPriorityQueue maxHeap = new MaxHeapPriorityQueue();
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(1);

        // Print the elements of the max-heap
        System.out.println("Max heap elements:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
