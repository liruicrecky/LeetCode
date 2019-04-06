import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (43.95%)
 * Total Accepted:    93.8K
 * Total Submissions: 211.9K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> timesStack = new Stack<>();
        List<Character> tmp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len;) {
            if (Character.isDigit(chars[i])) {
                int count = 0;
                while (Character.isDigit(chars[i])) {
                    count = count * 10 + chars[i] - '0';
                    ++i;
                }
                timesStack.push(count);
            } else if (chars[i] != ']') {
                stack.push(chars[i]);
                ++i;
            } else {
                while (stack.peek() != '[') {
                    tmp.add(stack.pop());
                }
                stack.pop();
                
                int times = timesStack.pop();

                while (times > 0) {
                    for (int j = tmp.size() - 1; j >= 0; j--) {
                        stack.push(tmp.get(j));
                    }
                    --times;
                }
                tmp.clear();
                ++i;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

