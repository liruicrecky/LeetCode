class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String str : set) {
            maxLen = Math.max(maxLen, str.length());
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > maxLen) {
                    break;
                }

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}