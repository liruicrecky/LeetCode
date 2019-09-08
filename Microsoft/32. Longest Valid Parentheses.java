class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        int opened = 0, max = 0;
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