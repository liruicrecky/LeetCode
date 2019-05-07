/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */
class Solution {
    public int addDigits(int num) {
        if (num < 10) { return num; }
        while (num >= 10) {
            int t = 0;
            while (num != 0) {
                t += num % 10;
                num /= 10;
            }
            num = t;
        }

        return num;
    }
}

