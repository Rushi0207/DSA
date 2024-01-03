public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String test1 = "01212";
        int result1 = solution.smallestSubstring(test1);
        System.out.println("Test 1: " + result1);  // Output: 3

        String test2 = "12121";
        int result2 = solution.smallestSubstring(test2);
        System.out.println("Test 2: " + result2);  // Output: -1

        // Add more test cases as needed
    }
}
class Solution {
    public int smallestSubstring(String S) {
        int count0 = 0, count1 = 0, count2 = 0;
        int uniqueCount = 0;
        int minLength = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int endIdx = 0; endIdx < S.length(); endIdx++) {
            char currentChar = S.charAt(endIdx);
            if (currentChar == '0' && count0 == 0) {
                uniqueCount++;
            } else if (currentChar == '1' && count1 == 0) {
                uniqueCount++;
            } else if (currentChar == '2' && count2 == 0) {
                uniqueCount++;
            }

            if (currentChar == '0') count0++;
            else if (currentChar == '1') count1++;
            else if (currentChar == '2') count2++;

            while (uniqueCount == 3) {
                minLength = Math.min(minLength, endIdx - startIdx + 1);

                char leftChar = S.charAt(startIdx);
                if (leftChar == '0') {
                    count0--;
                    if (count0 == 0) uniqueCount--;
                } else if (leftChar == '1') {
                    count1--;
                    if (count1 == 0) uniqueCount--;
                } else if (leftChar == '2') {
                    count2--;
                    if (count2 == 0) uniqueCount--;
                }

                startIdx++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}

