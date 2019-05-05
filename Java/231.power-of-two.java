/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

