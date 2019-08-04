class Solution {
    public int maxArea(int[] height) {
        int s = 0, e = height.length - 1;
        int max = -1;
        while (s < e) {
            max = Math.max(max, (e - s) * Math.min(height[s], height[e]));
            if (height[s] > height[e]) {
                int preEnd = height[e];
                while (height[e] <= preEnd && s < e) {
                    --e;
                }
            } else {
                int preStr = height[s];
                while (height[s] <= preStr && s < e) {
                    ++s;
                }
            }
        }
        
        return max;
    }
}