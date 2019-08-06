class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length, cols = matrix.length;

        for (int i = 0; i < rows >> 1; i++) {
            int[] tRow = matrix[i];
            matrix[i] = matrix[rows - i - 1];
            matrix[rows - i - 1] = tRow;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}