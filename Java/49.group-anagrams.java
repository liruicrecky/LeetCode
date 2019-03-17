import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (44.94%)
 * Total Accepted:    303.7K
 * Total Submissions: 673.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    private List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) { return Collections.emptyList(); }
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = String.valueOf(c);
            if (!m.containsKey(k)) {
                m.put(k, new ArrayList<String>());
            }
            m.get(k).add(s);
        }
        return new ArrayList<>(m.values());
    }

    private List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) { return Collections.emptyList(); }
        Map<String, List<String>> m = new HashMap<>();
        int[] charCount = new int[26];
        for (String s : strs) {
            Arrays.fill(charCount, 0);
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charCount.length; i++) {
                sb.append('#');
                sb.append(charCount[i]);
            }
            String k = sb.toString();
            if (!m.containsKey(k)) {
                m.put(k, new ArrayList<String>());
            }
            m.get(k).add(s);
        }
        return new ArrayList<>(m.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagrams2(strs);
    }
}

