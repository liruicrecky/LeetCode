/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.63%)
 * Total Accepted:    357.1K
 * Total Submissions: 878.1K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) { return res; }
        Map<String, String> m = new HashMap<>();
        m.put("2", "abc");
        m.put("3", "def");
        m.put("4", "ghi");
        m.put("5", "jkl");
        m.put("6", "mno");
        m.put("7", "pqrs");
        m.put("8", "tuv");
        m.put("9", "wxyz");
        backTrace(res, m, "", digits);
        return res;
    }
    private void backTrace(List<String> res, Map<String, String> m, String tmp, String digits) {
        if (digits.length() == 0) {
            res.add(tmp);
        } else {
            String s = digits.substring(0, 1);
            String ls = m.get(s);
            for (int i = 0; i < ls.length(); i++) {
                String l = ls.substring(i, i + 1);
                backTrace(res, m, tmp + l, digits.substring(1));
            }  
        }
    }
}

