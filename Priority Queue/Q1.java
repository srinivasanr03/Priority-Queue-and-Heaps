import java.util.*;

public class Q1 {

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue to sort characters by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        maxHeap.addAll(charCount.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            if (result.length() == 0 || current != result.charAt(result.length() - 1)) {
                result.append(current);
                charCount.put(current, charCount.get(current) - 1);
                if (charCount.get(current) > 0) {
                    maxHeap.offer(current);
                }
            } else {
                // If the current character is the same as the last one in the result,
                // try to get the next most frequent character and append it to the result.
                char next = maxHeap.isEmpty() ? '\0' : maxHeap.poll();
                if (next == '\0') {
                    return ""; // No other character to append, not possible to rearrange
                }
                result.append(next);
                charCount.put(next, charCount.get(next) - 1);
                if (charCount.get(next) > 0) {
                    maxHeap.offer(next);
                }
                // Add the current character back to the priority queue
                maxHeap.offer(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Q1 solution = new Q1();
        
        // Example usage
        String s = "aab";
        System.out.println("Original string: " + s);
        System.out.println("Rearranged string: " + solution.reorganizeString(s));
    }
}
