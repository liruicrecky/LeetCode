class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }

        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> res = new ArrayList<>(rows * cols);
        int left = 0, top = 0;
        int right = cols - 1, bottom = rows - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            ++top;
            if (top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            --right;
            if (left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            --bottom;
            if (top > bottom) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            ++left;
            if (left > right) {
                break;
            }
        }

        return res;
    }
}