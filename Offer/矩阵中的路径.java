public class Solution {
    private int length = 0;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows < 1 || cols < 1 || str == null || str.length == 0) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int[] dir = new int[] { 0, 1, 0, -1, 0 };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, str, visited, dir)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited,
            int[] dir) {
        if (str.length == length) {
            return true;
        }

        boolean findPath = false;
        if (row < rows && row >= 0 && col < cols && col >= 0 && matrix[row * cols + col] == str[length]
                && !visited[row * cols + col]) {
            ++length;
            visited[row * cols + col] = true;
            for (int i = 0; i < 4; i++) {
                findPath = findPath || hasPath(matrix, rows, cols, row + dir[i], col + dir[i + 1], str, visited, dir);
            }

            if (!findPath) {
                --length;
                visited[row * cols + col] = false;
            }
        }

        return findPath;
    }
}