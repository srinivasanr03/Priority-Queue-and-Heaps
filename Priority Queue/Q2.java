import java.util.*;

public class Q2 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // Add the first pair (nums1[0], nums2[0]) to the priority queue
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0}); // {sum, nums2 element, index in nums2}
        }

        // Poll the k smallest pairs from the priority queue
        while (k-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(current[0]);
            pair.add(current[1]);
            result.add(pair);

            if (current[2] == nums2.length - 1) {
                continue; // No more elements in nums2 for the current nums1 element
            }

            // Add the next pair (nums1[current[2] + 1], nums2[current[2] + 1]) to the priority queue
            pq.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
        }

        return result;
    }

    public static void main(String[] args) {
        Q2 solution = new Q2();

        // Example usage
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> pairs = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println("The " + k + " smallest pairs are:");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
