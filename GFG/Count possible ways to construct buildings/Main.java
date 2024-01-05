public class Main{
    public static void main(String args[]){
        Solution solution =new Solution();
        System.out.println("Numbers of ways to build the building are: "+solution.TotalWays(3));

        
        System.out.println("Numbers of ways to build the building are: "+solution.TotalWays(5));

        
        System.out.println("Numbers of ways to build the building are: "+solution.TotalWays(10));
    }
}
class Solution{
    static final int MOD=1000000007;
    public int TotalWays(int N)
    {
        // Code here
        long mod = 1000000007;
		long [] f = new long[N+1];
		f[0] = f[1] = 1;
		for(int i = 2; i <= N; i++)
			f[i]  = (f[i-1]%mod + f[i-2]%mod)%mod; // calculating Fibonacci numbers using dynamic programming
		long x = (f[N] + f[N-1])%mod; // calculating the sum of the last two Fibonacci numbers
		x = x * x; // squaring the sum
		x %= mod; // taking modulo
		return (int)x; // returning the result as an integer
        
    }
}