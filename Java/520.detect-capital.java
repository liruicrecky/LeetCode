/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 *
 * https://leetcode.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (52.44%)
 * Likes:    315
 * Dislikes: 201
 * Total Accepted:    86K
 * Total Submissions: 163.7K
 * Testcase Example:  '"USA"'
 *
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "USA"
 * Output: True
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "FlaG"
 * Output: False
 * 
 * 
 * 
 * 
 * Note: The input will be a non-empty word consisting of uppercase and
 * lowercase latin letters.
 * 
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = Character.isUpperCase(word.charAt(0)) ? true : false;
        int len = word.length();
        if (!first && len > 1 && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        for (int i = 2; i < len; i++) {
            if (first) {
                if (Character.isUpperCase(word.charAt(i - 1)) && Character.isLowerCase(word.charAt(i))
                    || Character.isLowerCase(word.charAt(i - 1)) && Character.isUpperCase(word.charAt(i))) {
                        return false;
                }
            } else {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}

