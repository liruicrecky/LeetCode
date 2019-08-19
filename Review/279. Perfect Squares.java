class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int left = i - j * j;
                if (dp[i] == 0) {
                    dp[i] = dp[left] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[left] + 1);
                }
            }
        }

        return dp[n];
    }
}