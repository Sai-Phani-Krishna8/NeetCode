class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    int perimeter = 0;

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        int x = curr[0], y = curr[1];

                        for(int[] dir:dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];

                            if(nx<0 || ny<0 || nx>=rows || ny>= cols || grid[nx][ny] == 0) {
                                perimeter++;
                            } else if(!visited[nx][ny]) {
                                q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}