import java.util.*;

public class q2 {

    public int minCostToConnectRopes(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all ropes to the min-heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        
        int totalCost = 0;
        
        // Combine ropes until only one rope is left in the heap
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int combined = first + second;
            totalCost += combined;
            minHeap.offer(combined);
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        q2 solution = new q2();

        // Example usage
        int[] ropes = {4, 3, 2, 6};
        int minCost = solution.minCostToConnectRopes(ropes);
        System.out.println("Minimum cost to connect ropes: " + minCost);
    }
}
