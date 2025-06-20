class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(grid,visited,m,n,i,j);
                }
            }
        }
        return count;
        
    }
    public void bfs(char[][] grid, int[][] visited, int m, int n,int i, int j){
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(i,j));
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            for(int k = 0;k<4;k++){
                
                    int newRow = x+dx[k];
                    int newCol = y+dy[k];
                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && visited[newRow][newCol]==0 && grid[newRow][newCol]=='1'){
                        visited[newRow][newCol]=1;
                        q.offer(new Pair(newRow,newCol));
                    }
                
            }
        }

    }
    static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
