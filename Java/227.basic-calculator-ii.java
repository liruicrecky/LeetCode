/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (33.45%)
 * Likes:    691
 * Dislikes: 109
 * Total Accepted:    110.8K
 * Total Submissions: 330.2K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * 
 * Input: "3+2*2"
 * Output: 7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * 
 * 
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> operands = new ArrayDeque<>();
        int len = s.length(), num = 0;
        char op = '+';

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                continue;
            }

            cal(operands, op, num);
            num = 0;
            op = c;
        }

        cal(operands, op, num);
        num = 0;

        while (!operands.isEmpty()) {
            num += operands.pop();
        }

        return num;
    }

    private void cal(ArrayDeque<Integer> s, char operator, int operand) {
        switch (operator) {
            case '+':
                s.push(operand);
                break;
            case '-':
                s.push(-operand);
                break;
            case '*':
                s.push(s.pop() * operand);
                break;
            case '/':
                s.push(s.pop() / operand);
                break;
            default:
                break;
        }
    }
}

