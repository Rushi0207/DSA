//https://leetcode.com/problems/set-matrix-zeroes/description/

public class Matrixzero {
    public static void main(String args[]){
        int[][] matrix={
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
        printMatrix(matrix);
    }
    public static void setZeroes(int[][] matrix){
        int rowCount= matrix.length,colCount=matrix[0].length;
        boolean isRow=false,isColumn=false;
        for(int i=0;i<rowCount;i++){
            if(matrix[i][0]==0) isColumn=true;
            break;
        }
        for(int i=0;i<colCount;i++){
            if(matrix[0][i]==0) isRow=true;
            break;
        }
        for(int i=1;i<rowCount;i++){
            for(int j=1;j<colCount;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<rowCount;i++){
            for(int j=1;j<colCount;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if(isRow){
            for(int i=0;i<colCount;i++){
                matrix[0][i]=0;
            }
        }
        if(isColumn){
            for(int i=0;i<rowCount;i++){
                matrix[i][0]=0;
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
