public class Main {
    public static void main(String args[]){
        Solution solution = new Solution();
        String[] bank={"011001","000000","0100100","001000"};
        int result=solution.numberOfBeams(bank);
        System.out.println("Number of Beams are:"+result);
        String[] bank1={"000","111","000"};
        result=solution.numberOfBeams(bank1);
        System.out.println("Number of Beams are:"+result);
    }
}
class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int prevCount = 0;

        for (String s : bank) {
            int currentCount = countOnes(s);

            if (currentCount > 0) {
                sum += prevCount * currentCount;
                prevCount = currentCount;
            }
        }
        return sum;
    }

    private int countOnes(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}
