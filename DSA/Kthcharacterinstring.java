import java.sql.SQLOutput;

public class Kthcharacterinstring {
    public static void main(String args[]){
//        Solution sol = new Solution();
//        char c=sol.kthCharacter(5);
//        System.out.println(c);
//        c = sol.kthCharacter(10);
//        System.out.println(c);
        Solution2 sol = new Solution2();
        int[] arr ={0, 0, 0, 0};
        char c = sol.kthCharacter(10,arr);
        System.out.println(c);
        int[] arr2={1,0,0,0,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,1};
        long k=2147483649l;
        c= sol.kthCharacter(28809802,arr2);
        System.out.println(c);
    }

}
class Solution {
    public char kthCharacter(int k) {
        StringBuilder str=new StringBuilder("a");
        while(str.length()<k){
            StringBuilder newPart = new StringBuilder('b');
            for(int i=0;i<str.length();i++){
                char nextChar = newChar(str.charAt(i));
                newPart.append(nextChar);
            }
            str.append(newPart);
        }
        return str.charAt(k-1);
    }
    private char newChar(char c){
        if(c=='z'){
            return 'a';
        }
        return (char) (c+1);
    }
}

class Solution2 {
    public char kthCharacter(long k, int[] operations) {
        StringBuilder str = new StringBuilder("a");
        //System.out.print("String is : " + str.toString());
        for(int i=0;i<operations.length;i++){
            if(operations[i]==1){
                StringBuilder newPart = new StringBuilder();
                for(int j=0;j<str.length();j++){
                    char nextChar=newChar(str.charAt(j));
                    newPart.append(nextChar);
                }
                str.append(newPart);
            }
            else{
                StringBuilder newPart = new StringBuilder(str);
                str.append(newPart);
            }
        }
        //System.out.print("String is : "+str.toString());
        return (char)(str.charAt((int) (k-1)));

    }
    private char newChar(char c){
        if(c=='z') return 'a';
        return (char) (c+1);
    }
}