class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum < S || ((sum + S) & 1) == 1 ? 0 : subSet(nums, (sum + S) >>> 1);
    }

    private int subSet(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = s; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[s];
    }
}