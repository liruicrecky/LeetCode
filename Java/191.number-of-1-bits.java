/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */
public class Solution {
    // you need to treat n as an unsigned value

    private int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            ++res;
            n &= n - 1;
        }

        return res;
    }

    private int hammingWeight1(int n) {
        int res = 0;
        int i = 0;
        while (i < 32) {
            if ((n & 1) == 1) {
                ++res;
            }
            n >>= 1;
            ++i;
        }

        return res;
    }

    public int hammingWeight(int n) {
        return hammingWeight2(n);
    }
}

