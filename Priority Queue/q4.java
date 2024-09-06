import java.util.*;

public class q4 {

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Store the sum of the first row and its index in the format [sum, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] firstRow = new int[n];
        int sum = 0;
        for (int j = 0; j < n; j++) {
            firstRow[j] = mat[0][j];
            sum += firstRow[j];
        }
        pq.offer(new int[]{sum, 0});

        // Generate the sums of subsequent rows
        for (int i = 1; i < m; i++) {
            PriorityQueue<int[]> tempPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                for (int j = 0; j < n; j++) {
                    int newSum = current[0] + mat[i][j] - firstRow[current[1]];
                    tempPQ.offer(new int[]{newSum, current[1]});
                }
            }

            // Choose the smallest k elements
            int count = 0;
            while (count < k && !tempPQ.isEmpty()) {
                pq.offer(tempPQ.poll());
                count++;
            }
        }

        // Get the kth smallest sum
        while (k > 1 && !pq.isEmpty()) {
            pq.poll();
            k--;
        }

        // Return -1 if pq is empty, indicating kth smallest sum cannot be found
        return pq.isEmpty() ? -1 : pq.peek()[0];
    }

    public static void main(String[] args) {
        q4 solution = new q4();

        // Example usage
        int[][] mat = {
            {1, 3, 11},
            {2, 4, 6}
        };
        int k = 5;
        int kthSmallestSum = solution.kthSmallest(mat, k);
        System.out.println("The " + k + "th smallest array sum is: " + kthSmallestSum);
    }
}
