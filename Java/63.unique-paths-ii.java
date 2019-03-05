/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (33.22%)
 * Total Accepted:    184.1K
 * Total Submissions: 554.2K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j == 0 && dp[j] == 0) {
                    continue;
                } else if (j != 0) {
                    dp[j] += dp[j - 1]; 
                }
            }
        }
        return dp[col - 1];
    }
}

