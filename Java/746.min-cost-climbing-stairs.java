/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * algorithms
 * Easy (46.06%)
 * Total Accepted:    68.1K
 * Total Submissions: 147.7K
 * Testcase Example:  '[0,0,0,0]'
 *
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the
 * top.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
 * cost[3].
 * 
 * 
 * 
 * Note:
 * 
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 * 
 * 
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
       // int[] memo = new int[cost.length + 1];
       //  eturn help(cost, cost.length, memo);
       return minCostClimbingStairs1(cost);
    }

    private int minCostClimbingStairs1(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = Math.min(f1, f2) + cost[i];
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    } 

    private int help(int[] cost, int i, int[] memo) {
        if (i == 0 || i == 1) { return 0; }
        if (memo[i] > 0) { return memo[i]; }
        return memo[i] = Math.min(help(cost, i - 1, memo) + 
            cost[i - 1], help(cost, i - 2, memo) + cost[i - 2]);
    }
}

