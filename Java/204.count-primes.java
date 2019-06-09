/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.99%)
 * Likes:    1056
 * Dislikes: 399
 * Total Accepted:    239.2K
 * Total Submissions: 823.1K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) { return 0; }
        boolean[] b = new boolean[n];
        int res = 1;

        for (int i = 3; i < n; i += 2) {
            if (!b[i]) {
                ++res;
                for (int j = i * i;i < Math.sqrt(Integer.MAX_VALUE) && j < n; j += i) {
                    b[j] = true;
                }
            }
        }

        return res;
    }
}

