/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (36.53%)
 * Total Accepted:    112.8K
 * Total Submissions: 306.9K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        List<Integer> res = new LinkedList<>();

        if (lenP > lenS) { return res; }
        Map<Character, Integer> m = new HashMap<>(); 

        for (char c : p.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int size = m.size();
        while(end < lenS) {
            char tc = s.charAt(end);
            if (m.containsKey(tc)) {
                m.put(tc, m.get(tc) - 1);
                if (m.get(tc) == 0) {
                    --size;
                } 
            }
            ++end;

            while (size == 0) {
                tc = s.charAt(start);
                if (m.containsKey(tc)) {
                    m.put(tc, m.get(tc) + 1);
                    if (m.get(tc) > 0) {
                        ++size;
                    }  
                }
                if (end - start == lenP) {
                    res.add(start);
                }
                ++start;
            }
        }

        return res;
    }
}

