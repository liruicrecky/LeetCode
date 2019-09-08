class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            } else {
                dp[0] = dp[0] == 0 ? 0 : 1;
            }
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[cols - 1];
    }
}