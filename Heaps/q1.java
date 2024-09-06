import java.util.*;

public class q1 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        q1 solution = new q1();

        // Example usage
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
