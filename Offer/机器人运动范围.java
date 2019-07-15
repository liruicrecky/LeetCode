public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];
        int[] dir = new int[] { 0, 1, 0, -1, 0 };

        return movingCount(threshold, rows, cols, 0, 0, visited, dir);
    }

    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited, int[] dir) {
        if (row >= rows || row < 0 || col >= cols || col < 0 || visited[row * cols + col]) {
            return 0;
        }

        int count = 0;

        if (check(threshold, row, col)) {
            visited[row * cols + col] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                count += movingCount(threshold, rows, cols, row + dir[i], col + dir[i + 1], visited, dir);
            }
        }

        return count;
    }

    private boolean check(int threshold, int row, int col) {
        int sum = 0;

        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }

        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }

        return sum <= threshold;
    }
}