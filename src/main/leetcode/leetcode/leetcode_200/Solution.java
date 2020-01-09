package leetcode_200;

class Solution {
    private int m,n;
    private boolean[][] isVisited;
    private int[][] around = {{0,-1},{1,0},{0,1},{-1,0}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0){
            return 0;
        }
        n = grid[0].length;
        int res = 0;
        isVisited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j]&&grid[i][j]=='1'){
                    res+=1;
                    bst(grid,i,j);
                }
            }
        }
        return res;

    }

    private boolean inArea(int i, int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }



    private void bst(char[][] grid, int startx, int starty){
        isVisited[startx][starty]=true;
        for (int[] ints : around) {
            int newx = startx + ints[0];
            int newy = starty + ints[1];
            if (inArea(newx, newy) && !isVisited[newx][newy] && grid[newx][newy] == '1') {
                bst(grid, newx, newy);
            }
        }
        return;
    }
}
