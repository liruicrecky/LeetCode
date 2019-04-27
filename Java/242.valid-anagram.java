/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }

        int[] hash = new int[27];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] <= 0) {
                return false;
            } else {
                hash[c - 'a']--;
            }
        }

        return true;
    }
}

