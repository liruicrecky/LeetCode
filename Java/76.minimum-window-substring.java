/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (29.92%)
 * Total Accepted:    219.5K
 * Total Submissions: 728.3K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        String res = "";
        if (lenT > lenS) { return res; }

        Map<Character, Integer> m = new HashMap<>();
        for (char c : t.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int size = m.size();
        int len = Integer.MAX_VALUE;

        while (end < lenS) {
            char c = s.charAt(end);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) - 1);
                if (m.get(c) == 0) {
                    --size;
                }
            }
            ++end;

            while (size == 0) {
                c = s.charAt(start);
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                    if (m.get(c) > 0) {
                        ++size;
                    }
                }
                if (end - start < len) {
                    res = s.substring(start, end);
                    len = end - start;
                }
                ++start;
            }
        }
        return res;
    }
}

