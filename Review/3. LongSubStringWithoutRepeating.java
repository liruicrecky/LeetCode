class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 2) {
            return s == null ? 0 : s.length();
        }
        
        int max = 1, len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        
        for (int i = 1; i < len; i++) {
            int j = 1;
            while (j <= dp[i - 1]) {
                if (s.charAt(i) == s.charAt(i - j)) {
                    break;
                }
                ++j;
            }
            
            if (j - 1 == dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            } else {
                dp[i] = j;
            }
        }
        
        return max;
    }
}