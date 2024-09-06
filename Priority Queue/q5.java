import java.util.*;

public class q5 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public q5() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // Balance the heaps if necessary
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        q5 medianFinder = new q5();

        // Example usage
        medianFinder.addNum(5);
        medianFinder.addNum(15);
        medianFinder.addNum(1);
        medianFinder.addNum(3);

        System.out.println("Median after adding 5, 15, 1, 3: " + medianFinder.findMedian());
    }
}
