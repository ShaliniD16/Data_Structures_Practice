class Solution {
    
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] dp;
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        
        
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int maxi = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                maxi = Math.max(maxi,dfs(i,j,-1,matrix));
            }
        }
        return maxi;
    }
    public int dfs(int r, int c, int prevValue, int[][] matrix){
        if(r<0 || r>=m || c<0 || c>=n || matrix[r][c]<=prevValue) return 0;
        if(dp[r][c]!=0) return dp[r][c];
        int res = 1;

        for(int[] dir: dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            res = Math.max(res,1+dfs(newRow,newCol,matrix[r][c],matrix));
        }
        dp[r][c] = res;
        return res;
    }
}
