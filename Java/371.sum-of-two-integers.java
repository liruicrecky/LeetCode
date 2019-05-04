/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public int getSum1(int a, int b) {
        if (a == 0) { return b; }
        if (b == 0) { return a; }
        int carry = a & b;
        return getSum1(a ^ b, carry);
    }
}

