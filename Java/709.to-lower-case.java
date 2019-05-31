/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 *
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * algorithms
 * Easy (76.31%)
 * Likes:    273
 * Dislikes: 920
 * Total Accepted:    106.4K
 * Total Submissions: 138.5K
 * Testcase Example:  '"Hello"'
 *
 * Implement function ToLowerCase() that has a string parameter str, and
 * returns the same string in lowercase.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "Hello"
 * Output: "hello"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "here"
 * Output: "here"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "LOVELY"
 * Output: "lovely"
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public String toLowerCase(String str) {
        if (str == null) { return null; }
        StringBuilder sb = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

