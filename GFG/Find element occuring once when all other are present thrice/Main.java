import java.util.*;
class Main{
    public static void main(String args[]){
        Solution solution=new Solution();
        int[] arr={1, 10, 1, 1};
        int num=solution.singleElement(arr,4);
        System.out.println("Single occuring element is: "+num);

        int[] arr1={3, 2, 1, 34, 34, 1, 2, 34, 2, 1};
        num=solution.singleElement(arr1,arr1.length);
        System.out.println("Single occuring element is: "+num);
    }
}
class Solution {
    static int singleElement(int[] arr , int N) {
        // code here
        int ones = 0, twos = 0;
        
        for (int i = 0; i < N; i++) {
            // Update twos for the bits that are set in the current element and also in ones
            twos |= (ones & arr[i]);

            // Update ones with the bits that are set in the current element but not in twos
            ones ^= arr[i];

            // The common bits between ones and twos are unset from ones
            int commonBitMask = ~(ones & twos);
            ones &= commonBitMask;
            twos &= commonBitMask;
        }

        return ones;
    }
}