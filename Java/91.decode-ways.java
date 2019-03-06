/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.89%)
 * Total Accepted:    239.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    private int numDecodings1(String s) {
        int length = s.length();
        int[] dp = new int[length];
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[0] = 1;
        }
       
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i) != '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 1];
                }
            } else if (s.charAt(i - 1) == '1' 
                || (s.charAt(i - 1) == '2' && (int)(s.charAt(i) - '0') < 7)) {
                dp[i] = dp[i - 1] + 1; 
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
       
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else if (s.charAt(i) == '1') {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (s.charAt(i) == '2' && (int)(s.charAt(i + 1) - '0') < 7) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }   
        return dp[0];
    }
}

