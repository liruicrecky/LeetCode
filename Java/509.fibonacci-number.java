/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */
class Solution {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        return help(N, memo);
    }

    private int help(int N, int[] memo) {
        if (N == 0) { return 0; }
        if (N == 1) { return 1; }
        if (memo[N] > 0) { return memo[N]; }
        return memo[N] = help(N - 1, memo) + help(N - 2, memo);
    }
}

