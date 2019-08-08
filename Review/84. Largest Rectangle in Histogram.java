class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = -1;
        rightMax[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[i] <= heights[p]) {
                p = leftMax[p];
            }
            leftMax[i] = p;
        }

        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[i] <= heights[p]) {
                p = rightMax[p];
            }
            rightMax[i] = p;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (rightMax[i] - leftMax[i] - 1));
        }

        return max;
    }
}