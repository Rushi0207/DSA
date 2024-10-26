import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] nums1 = {5, 6 , 7, 8, 9, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 4, 5};
        int m=5;
        int n=4;
        solution.merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
}
class Solution{
    public static void merge(int[] nums1, int m, int[] nums2,int n){
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int mergedIndex = m + n - 1; // Pointer for the merged array (nums1)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[mergedIndex] = nums1[i];
                i--;
            } else {
                nums1[mergedIndex] = nums2[j];
                j--;
            }
            mergedIndex--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[mergedIndex] = nums2[j];
            j--;
            mergedIndex--;
        }
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        for(int k=m;k<m+n;k++){
            nums1[k]=nums2[k-m];
        }
        Arrays.sort(nums1);
    }
}
