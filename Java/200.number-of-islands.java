/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (40.39%)
 * Total Accepted:    315.9K
 * Total Submissions: 778.3K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    private class Point{
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[] offsets = new int[] {0, -1, 0, 1, 0};
    private void dfs(char[][] grid, int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                dfs(grid, x + offsets[i], y + offsets[i + 1]);
            }
        }
    }

    private int bfs(char[][] grid) {
        int row = grid.length;
        int col = row == 0 ? 0 : grid[0].length;
        int count = 0;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count++;
                    Point p = new Point(i, j);
                    q.offer(p);
                    while (!q.isEmpty()) {
                        Point t = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = offsets[k] + t.x;
                            int y = offsets[k + 1] + t.y;
                            if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                Point pt = new Point(x, y);
                                q.offer(pt);
                            }
                        }
                    }

                }
            }
        }
        return count;
    }
    public int numIslands(char[][] grid) {
        // dfs
        /*
       int count = 0;
       int row = grid.length;
       int col = row == 0 ? 0 : grid[0].length;
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               if (grid[i][j] == '1') {
                   dfs(grid, i, j);
                   count++;
               }
           }
       }
       return count;
       */
      return bfs(grid);
    }
}

