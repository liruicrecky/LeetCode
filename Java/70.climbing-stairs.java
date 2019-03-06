/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (43.47%)
 * Total Accepted:    359.7K
 * Total Submissions: 827.3K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
class Solution {
    private int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return help(n, memo);
    }

    private int help(int n, int[] memo) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (memo[n] > 0) { return memo[n]; }
        return memo[n] = help(n - 1, memo) + help(n - 2, memo);
    }
    
    private int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int res = 0, p = 2, pp = 1;
        for (int i = 3; i <= n; i++) {
            res = p + pp;
            pp = p;
            p = res;
        }
        return res;
    }
    public int climbStairs(int n) {
        return climbStairs2(n);
    }
}

