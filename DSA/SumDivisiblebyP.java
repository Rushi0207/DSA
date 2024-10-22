
//https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2024-10-03
public class SumDivisiblebyP {
    public static void main(String args[]){
        int[] arr={26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        Solution3 sol = new Solution3();
        int ans=sol.minSubarray(arr,26);
        System.out.println(ans);
    }
}
class Solution3 {
    public int minSubarray(int[] nums, int p) {
        int sum=nums[0];
        int count=nums.length;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%p==0){
            return 0;
        }
        else{
            int remainder=sum%p;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==remainder) {
                    return 1;
                }
            }
            for(int i=0;i<nums.length;i++){
                int sum2=0,tcount=0;
                for(int j=i;j<nums.length;j++){
                    sum2+=nums[j];
                    tcount++;
                    if(remainder==sum2){
                        System.out.println("remainder: "+remainder);
                        count=Math.min(count,tcount);
                    }
                    System.out.println("remainder: "+remainder);
                }
            }
        }
        System.out.println("count: "+count+" sum"+sum);
        return nums.length==count? -1: count;
    }
}