/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (46.37%)
 * Total Accepted:    59.7K
 * Total Submissions: 127.9K
 * Testcase Example:  '[3,1,5,8]'
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * Example:
 * 
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  -->
 * []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 */
class Solution {
    private int help(int[] nums, int start, int end, int[][] memo) {
        if (start + 1 == end) {
            return 0;
        }

        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        
        int ans = 0;
        for (int i = start + 1; i < end; i++) {
            ans = Math.max(ans,
                help(nums, start, i, memo) + nums[start] * nums[i] * nums[end] + help(nums, i, end, memo));
        }

        return memo[start][end] = ans;
    }

    private int maxCoins1(int[] nums) {
        int len = nums.length;
        int[] coins = new int[len+2];
        for (int i = 1; i <= len; i++) {
            coins[i] = nums[i-1];
        }
        coins[0] = coins[len + 1] = 1;

        return help(coins, 0, len + 1, new int[len+2][len+2]);
    }

    private int maxCoins2(int[] nums) {
        int len = nums.length;
        int[] coins = new int[len+2];
        for (int i = 1; i <= len; i++) {
            coins[i] = nums[i-1];
        }
        coins[0] = coins[len + 1] = 1;

        int[][] dp = new int[len+2][len+2];
        for (int i = 2; i < len + 2; i++) {
            for (int start = 0; start < len + 2 - i; start++) {
                int end = start + i;
                for (int j = start + 1; j < end; j++) {
                    dp[start][end] = Math.max(dp[start][end],
                        dp[start][j] + coins[start]*coins[j]*coins[end] + dp[j][end]);
                }
            }
        }

        return dp[0][len + 1];
    }

    public int maxCoins(int[] nums) {
        return maxCoins1(nums);
    }
}

