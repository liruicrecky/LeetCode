class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curMax = 0, prevMax = 0;
        for (int num : nums) {
            int t = curMax;
            curMax = Math.max(curMax, prevMax + num);
            prevMax = t;
        }

        return curMax;
    }
}