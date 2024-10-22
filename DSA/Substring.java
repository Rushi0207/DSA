import java.util.HashSet;
import java.util.Set;

public class Substring{
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        // Example 1
        String word1 = "aeioqq";
        int k1 = 1;
        System.out.println(sol.countOfSubstrings(word1, k1));  // Output: 0

        // Example 2
        String word2 = "aeiou";
        int k2 = 0;
        System.out.println(sol.countOfSubstrings(word2, k2));  // Output: 1

        // Example 3
        String word3 = "ieaouqqieaouqq";
        int k3 = 1;
        System.out.println(sol.countOfSubstrings(word3, k3));  // Output: 3
    }
}

class Solutions {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;

        // Helper function to check if a character is a vowel
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // Sliding window approach
        for (int i = 0; i < n; i++) {
            int consonantCount = 0;
            Set<Character> vowelSet = new HashSet<>();

            // Expand the window
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);

                // Check if it's a vowel
                if (vowels.contains(ch)) {
                    vowelSet.add(ch);  // Track the vowel
                } else {
                    // It's a consonant, increment the count
                    consonantCount++;
                }

                // If we have exactly k consonants and all vowels
                if (consonantCount == k && vowelSet.size() == 5) {
                    count++;  // This substring is valid
                }

                // If we exceed the allowed consonant count, break
                if (consonantCount > k) {
                    break;
                }
            }
        }

        return count;
    }
}
