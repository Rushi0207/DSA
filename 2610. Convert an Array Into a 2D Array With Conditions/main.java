import java.util.*;
public class main{
public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> result1 = solution.findSolution(nums1);
        System.out.println("Output 1: " + result1);  // Output: [[1, 3, 4, 2], [1, 3], [1]]

        int[] nums2 = {1, 2, 3, 4};
        List<List<Integer>> result2 = solution.findSolution(nums2);
        System.out.println("Output 2: " + result2);  // Output: [[4, 3, 2, 1]]
    }
}

class Solution {
    public List<List<Integer>> findSolution(int[] nums) {
        // Convert the input array to a list to facilitate sorting
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        // Sort the list in descending order
        Collections.sort(numsList, Collections.reverseOrder());

        List<List<Integer>> result = new ArrayList<>();

        for (int num : numsList) {
            boolean found = false;
            for (List<Integer> row : result) {
                if (!row.contains(num)) {
                    row.add(num);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<Integer> newRow = new ArrayList<>();
                newRow.add(num);
                result.add(newRow);
            }
        }

        return result;
    }
}
