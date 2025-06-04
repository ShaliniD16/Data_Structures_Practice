class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> ind = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    ind.add(li);
                }
            }
        }
        for(ArrayList<Integer> li:ind){
            for(int k = 0;k<matrix[0].length;k++){
                matrix[li.get(0)][k]=0;
            }
            for(int j = 0;j<matrix.length;j++){
                matrix[j][li.get(1)] = 0;
            }
        }
    }
}
