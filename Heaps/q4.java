import java.util.*;

public class q4 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add stones to the max-heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Smash stones until only one stone is left
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x != y) {
                maxHeap.offer(y - x);
            }
        }
        
        // Return the weight of the last remaining stone
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        q4 solution = new q4();

        // Example usage
        int[] stones = {2, 7, 4, 1, 8, 1};
        int lastRemainingWeight = solution.lastStoneWeight(stones);
        System.out.println("Weight of the last remaining stone: " + lastRemainingWeight);
    }
}
