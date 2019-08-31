class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = rows == 0 ? 0 : grid[0].length;
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, rows, cols, i, j, dir);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int rows, int cols, int i, int j, int[] dir) {
        if (i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == '1') {
            grid[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                dfs(grid, rows, cols, i + dir[k], j + dir[k + 1], dir);
            }
        }
    }
}