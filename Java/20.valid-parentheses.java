import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.96%)
 * Total Accepted:    530.7K
 * Total Submissions: 1.5M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length() && res) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.empty()) {
                    res = false;
                    break;
                }
                switch (s.charAt(i)) {
                    case ')':
                        if (st.peek() == '(') {
                            st.pop();
                        } else {
                            res = false;
                        }
                        break;
                    case '}':
                        if (st.peek() == '{') {
                            st.pop();
                        } else {
                            res = false;
                        }
                        break;
                    case ']':
                        if (st.peek() == '[') {
                            st.pop();
                        } else {
                            res = false;
                        }
                        break;
                    default:
                        res = false;
                        break;
                }
            } else {
                st.push(s.charAt(i));
            }
            i++;
        }
        if (!st.empty()) {
            res = false;
        }

        return res;
    }
}

