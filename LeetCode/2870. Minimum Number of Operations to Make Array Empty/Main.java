import java.util.*;
public class Main {
    public static void main(String args[]){
        Solution solution =new Solution();
        Scanner sc= new Scanner(System.in);
        int[] nums={2,3,3,2,2,4,2,3,4};
        int result=solution.minOperations(nums);
        if(result==-1){
            System.out.println("It not possible to empty an array.");
        }
        else{
            System.out.println("Number of operations required to empty an array are: "+result);
        }
        int[] nums1={2,1,2,2,3,3,};
        result=solution.minOperations(nums1);
        if(result==-1){
            System.out.println("It not possible to empty an array.");
        }
        else{
            System.out.println("Number of operations required to empty an array are: "+result);
        }
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        result=solution.minOperations(arr);
        if(result==-1){
            System.out.println("It not possible to empty an array.");
        }
        else{
            System.out.println("Number of operations required to empty an array are: "+result);
        }

    }
}

class Solution{
    public int minOperations(int[] nums){
        Map<Integer,Integer> count=new HashMap<>();
         for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        
        int ans = 0;
        
        // Calculate operations based on counts
        for (int c : count.values()) {
            if (c < 2) {
                return -1;
            }
            
            ans += c / 3 + (c % 3 == 0 ? 0 : 1);
        }
        
        return ans;
    } 
}