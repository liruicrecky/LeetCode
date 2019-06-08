/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.46%)
 * Likes:    1084
 * Dislikes: 412
 * Total Accepted:    236.1K
 * Total Submissions: 773.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = rows == 0 ? 0 : matrix[0].length;
        List<Integer> res = new ArrayList<>(rows + cols);

        int times = 0;

        while (rows > times * 2 && cols > times * 2) {

            int endX = cols - times - 1;
            int endY = rows - times - 1;
            
            // up
            for (int i = times; i <= endX; i++) {
                res.add(matrix[times][i]);
            }

            // right
            if (times < endY) {
                for (int i = times + 1; i <= endY; i++) {
                    res.add(matrix[i][endX]);
                }
            }

            // bottom
            if (times < endX && times < endY) {
                for (int i = endX - 1; i >= times; i--) {
                    res.add(matrix[endY][i]);
                }
            }

            // right
            if (times < endX && times < endY - 1) {
                for (int i = endY - 1; i >= times + 1; i--) {
                    res.add(matrix[i][times]);
                }
            }

            ++times;
        }

        return res;
    }
}

