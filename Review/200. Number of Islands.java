class Solution {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = rows == 0 ? 0 : grid[0].length;
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        /*
         * int count = 0; for (int i = 0; i < rows; i++) { for (int j = 0; j < cols;
         * j++) { if (grid[i][j] == '1') { ++count; DFS(grid, i, j, rows, cols, dir); }
         * } }
         * 
         * return count;
         */
        return BFS(grid, rows, cols, dir);
    }

    private int BFS(char[][] grid, int rows, int cols, int[] dir) {
        int count = 0;
        ArrayDeque<Point> que = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                ++count;
                grid[i][j] = '1';
                que.add(new Point(i, j));
                while (!que.isEmpty()) {
                    Point t = que.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = t.x + dir[k];
                        int y = t.y + dir[k + 1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            grid[x][y] = '0';
                            que.add(new Point(x, y));
                        }
                    }
                }
            }
        }

        return count;
    }

    private void DFS(char[][] grid, int i, int j, int rows, int cols, int[] dir) {
        if (i >= 0 && j >= 0 && i < rows && j < cols && grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                DFS(grid, i + dir[k], j + dir[k + 1], rows, cols, dir);
            }
        }
    }
}