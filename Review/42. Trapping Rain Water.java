class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int len = height.length;
        int leftMax = height[0], rightMax = height[len - 1];
        int left = 1, right = len - 2;
        int water = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                ++left;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                --right;
            }
        }

        return water;
    }
}