public class sqrt {
    public static void main(String args[]){
        mySqrt root = new mySqrt();
        int r=root.mySqrt(2147483647);
        System.out.println(r);
    }
}
class mySqrt {
    public int mySqrt(int x) {
        long left=1;
        long right=x+1;
        while(left<right){
            final long mid=left+(right-left)/2;
            if(mid>x/mid){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return (int)left-1;
    }
}