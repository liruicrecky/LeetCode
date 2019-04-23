/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */
class Solution {
    public int titleToNumber(String s) {
        if (s == null) { return 0; }
        
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = ans * 26 + (s.charAt(i) - 'A' + 1);
        }

        return ans;
    }
}

