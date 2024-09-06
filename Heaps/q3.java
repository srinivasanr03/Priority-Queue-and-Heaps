import java.util.*;

public class q3 {

    public List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // Use a priority queue to store words based on their frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) ? w2.compareTo(w1) : freqMap.get(w1) - freqMap.get(w2)
        );
        
        // Add words to the priority queue
        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent word if the size exceeds k
            }
        }
        
        // Create a list to store the top k frequent words
        List<String> topK = new ArrayList<>();
        while (!pq.isEmpty()) {
            topK.add(pq.poll());
        }
        
        // Reverse the list to get the words sorted by frequency from highest to lowest
        Collections.reverse(topK);
        
        return topK;
    }

    public static void main(String[] args) {
        q3 solution = new q3();

        // Example usage
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> topKFrequentWords = solution.topKFrequent(words, k);
        System.out.println("The " + k + " most frequent words are: " + topKFrequentWords);
    }
}
