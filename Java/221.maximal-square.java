/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (32.31%)
 * Total Accepted:    119.8K
 * Total Submissions: 370.5K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 * 
 */
class Solution {
    private int self(char[][] matrix) {
        if (matrix.length == 0) { return 0; }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;

        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] > max) { max = dp[0][i]; }
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] > max) { max = dp[i][0]; }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > max) { max = dp[i][j]; }
                }
            }
        }

        return max * max;
    }

    private int maximalSquare1(char[][] matrix) {
        int row = matrix.length, col = row == 0 ? 0 : matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxLen = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    private int maximalSquare2(char[][] matrix) {
        int row = matrix.length, col = row == 0 ? 0 : matrix[0].length;
        int[] dp = new int[col + 1];
        int maxLen = 0, prev = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int t = dp[j];
                if (matrix[i - 1][j - 1] == '1') {   
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = t;
            }
        }
        return maxLen * maxLen;
    }

    public int maximalSquare(char[][] matrix) {
        return maximalSquar2(matrix);
    }
}

