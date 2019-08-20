class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int s = 0, e = size;
            while (s < e) {
                int m = (s + e) >>> 1;
                if (num > dp[m]) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }

            dp[s] = num;
            if (s == size) {
                ++size;
            }
        }

        return size;
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        memo[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int t = 0;
            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, memo[j]);
                }
                --j;
            }

            memo[i] = t + 1;
            max = Math.max(max, memo[i]);
        }

        return max;
    }
}