/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (31.33%)
 * Likes:    759
 * Dislikes: 1350
 * Total Accepted:    369.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */
class Solution {
    private int binarySearch(int x) {
        if ( x <= 1) { return x; }
        long s = 0, e = x / 2;
        int res = 0;

        while (s <= e) {
            long mid = (s + e) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                res = int(mid);
                break;
            } else if (mid * mid > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }

    public int mySqrt(int x) {
        if (x == 0) { return 0; }
        double last = 0, res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }

        return (int)res;
    }
}

