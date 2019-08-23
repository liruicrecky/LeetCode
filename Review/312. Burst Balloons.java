class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] iNums = new int[nums.length + 2];
        int index = 1;
        for (int num : nums) {
            if (num > 0) {
                iNums[index++] = num;
            }
        }
        iNums[0] = 1;
        iNums[index++] = 1;

        int[][] dp = new int[index][index];
        for (int interval = 2; interval < index; interval++) {
            for (int left = 0; left < index - interval; left++) {
                int right = left + interval;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            iNums[left] * iNums[i] * iNums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][index - 1];
    }
}