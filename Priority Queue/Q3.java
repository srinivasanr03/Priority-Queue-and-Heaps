import java.util.*;
public class q3 {

    public int maximumScore(int a, int b, int c) {
        // Sort the piles to make the optimal moves
        int[] piles = {a, b, c};
        Arrays.sort(piles);

        int score = 0;

        // While there are at least two non-empty piles
        while (piles[1] > 0) {
            // Take one stone from the two largest piles
            piles[2]--;
            piles[1]--;
            // Increment the score
            score++;
            // Sort the piles again after taking stones
            Arrays.sort(piles);
        }

        return score;
    }

    public static void main(String[] args) {
        q3 solution = new q3();

        // Example usage
        int a = 2, b = 4, c = 6;
        int maxScore = solution.maximumScore(a, b, c);
        System.out.println("Maximum score: " + maxScore);
    }
}
