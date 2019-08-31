class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int len = height.length;
        int water = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public int trap1(int[] height) {
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