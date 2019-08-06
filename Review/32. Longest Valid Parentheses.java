class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, opened = 0, len = s.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == ')') {
                if (--opened >= 0) {
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += dp[i - dp[i]];
                    max = Math.max(max, dp[i]);
                } else {
                    opened = 0;
                }
            } else {
                ++opened;
            }
        }

        return max;
    }
}