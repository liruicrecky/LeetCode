/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (29.23%)
 * Total Accepted:    176.9K
 * Total Submissions: 596.8K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */
class Solution {
    private int res = Integer.MAX_VALUE;
    private boolean find = false;
    public int coinChange(int[] coins, int amount) {
        /*
        Arrays.sort(coins);
        backTrack(coins, coins.length - 1, amount, new ArrayList<Integer>());
        if (find) {
            return res;
        }

        return -1;
        return coinChange1(coins, amount, new int[amount]);
        */
        return coinChange2(coins, amount);
    }
        
    private int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private int coinChange1(int[] coins, int remain, int[] memo) {
       if (remain < 0) { return -1; }
       if (remain == 0) { return 0; }
       if (memo[remain - 1] != 0) { return memo[remain - 1]; }
       int min = Integer.MAX_VALUE;
       for (int coin : coins) {
           int res = coinChange1(coins, remain - coin, memo);
           if (res >= 0 && res < min) {
               min = res + 1;
           }
       }
       
       return memo[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
    }

    private void backTrack(int[] coins, int start, int remain, List<Integer> tmp) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res = Math.min(res, tmp.size());
            find = true;
        } else {
            for (int i = start; i >= 0; i--) {
                tmp.add(coins[i]);
                backTrack(coins, i, remain - coins[i], tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

