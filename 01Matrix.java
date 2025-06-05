class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir: dirs){
                int r = row+dir[0];
                int c = col+dir[1];
                if(r>=0 && r<m && c>=0 && c<n && !visited[r][c]){
                    res[r][c] = res[row][col]+1;
                    visited[r][c] = true;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return res;
    }
}
