class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int isUp = 1;
        int i = 0,j = 0,l=0;
        res[l++] = mat[i][j];
        for(int k = 1;k<m*n;k++){
            if(isUp==1){
                
                if(j==n-1){
                    i++;
                    isUp = 0;
                }
                else if(i==0){
                    j++;
                    isUp = 0;
                    
                }
                else{
                    i--;
                    j++;
                }
            }
            else{
                if(i==m-1){
                    j++;
                    isUp=1;
                }
                else if(j==0){
                    i++;
                    isUp=1;
                }
                else{
                    i++;
                    j--;
                }
            }
            res[l++] = mat[i][j];
        }
        return res;
    }
}
