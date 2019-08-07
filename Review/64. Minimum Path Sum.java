class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] memo = new int[cols];
        memo[0] = grid[0][0];

        for (int i = 1; i < cols; i++) {
            memo[i] = memo[i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    memo[j] += grid[i][j];
                } else {
                    memo[j] = grid[i][j] + Math.min(memo[j], memo[j - 1]);
                }
            }
        }

        return memo[cols - 1];
    }
}