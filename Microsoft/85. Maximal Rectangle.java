class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        int res = 0;

        Arrays.fill(right, cols);

        for (char[] chars : matrix) {
            int curLeft = 0, curRight = cols;
            for (int i = 0; i < cols; i++) {
                if (chars[i] == '1') {
                    height[i]++;
                    left[i] = Math.max(left[i], curLeft);
                } else {
                    height[i] = 0;
                    left[i] = 0;
                    curLeft = i + 1;
                }

                int j = cols - i - 1;
                if (chars[j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = cols;
                    curRight = j;
                }
            }

            for (int i = 0; i < cols; i++) {
                res = Math.max(res, height[i] * (right[i] - left[i]));
            }
        }

        return res;
    }
}