/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (39.81%)
 * Likes:    1056
 * Dislikes: 192
 * Total Accepted:    210.9K
 * Total Submissions: 528.7K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = rows == 0 ? 0 : matrix[0].length;
        boolean col = false;

        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                col = true;
            }

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int modified = 10000000;
        int rows = matrix.length, cols = rows == 0 ? 0 : matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < cols; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = modified;
                        }
                    }
                    for (int k = 0; k < rows; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = modified;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == modified) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }

    public void setZeroes1(int[][] matrix) {
        int rows = matrix.length, cols = rows == 0 ? 0 : matrix[0].length;

        boolean[][] isZeros = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    isZeros[i][j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isZeros[i][j]) {
                    setVal(matrix, i, j, rows, cols, 0);
                }
            }
        }
    }

    private void setVal(int[][] matrix, int x, int y, int rows, int cols, int val) {
        for (int i = 0; i < cols; i++) {
            matrix[x][i] = val;
        }

        for (int i = 0; i < rows; i++) {
            matrix[i][y] = val;
        }
    }
}

