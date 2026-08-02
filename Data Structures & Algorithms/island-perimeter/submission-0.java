class Solution {
    private boolean[][] visited;
    private int rows, cols;

    public int islandPerimeter(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j] == 0) {
            return 1;
        }
        if(visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i+1, j, grid) + dfs(i-1, j, grid) +
                dfs(i, j+1, grid) + dfs(i, j-1, grid);
    }
}