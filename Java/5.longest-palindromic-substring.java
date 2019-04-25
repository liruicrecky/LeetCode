/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int len = s.length();
        int lm = 0, rm = 0;
        for (int i = 0; i < len; i++) {
            int l = i, r = i;
            char c = s.charAt(i);
            
            while (l >= 0 && s.charAt(l) == c) {
                --l;
            }
            while (r < len && s.charAt(r) == c) {
                ++r;
            }

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
            }

            ++l;
            if (r - l > rm - lm) {
                rm = r;
                lm = l;
            }
        }

        return s.substring(lm, rm);
    }
}

