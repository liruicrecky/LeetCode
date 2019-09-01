class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int s = 0, e = height.length - 1;
        int max = -1;

        while (s < e) {
            max = Math.max(max, (e - s) * Math.min(height[s], height[e]));
            if (height[s] > height[e]) {
                int preEnd = height[e];
                while (s < e && height[e] <= preEnd) {
                    --e;
                }
            } else {
                int preStr = height[s];
                while (s < e && height[s] <= preStr) {
                    ++s;
                }
            }
        }

        return max;
    }
}