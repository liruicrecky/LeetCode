class Solution {

    private int self(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }

    private int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(nums[i] + rob1(nums, i - 2), rob1(nums, i - 1));
    }

    private int rob2(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        return memo[i] = Math.max(nums[i] + rob2(nums, i - 2, memo), rob2(nums, i - 1, memo));
    }

    private int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length + 1];
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + nums[i]);
        }
        return memo[nums.length];
    }

    private int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        for (int i : nums) {
            int t = p1;
            p1 = Math.max(p1, p2 + i);
            p2 = t;
        }
        return p1;
    }

    public int rob(int[] nums) {
        return rob4(nums);
    }
}
