/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (43.51%)
 * Total Accepted:    85.3K
 * Total Submissions: 195.6K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
 * day)
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 */
class Solution {
    private int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_buy, prev_sell - price);
            prev_sell = sell;
            sell = Math.max(prev_sell, prev_buy + price);
        }
        return sell;
    }

    private int maxProfit1(int[] prices) {
        int own = 0, notOwn = 0;
        int lastOwn = Integer.MIN_VALUE, lastNotOwn = 0, lastNotOwn2 = 0;
        int res = 0;

        for (int price : prices) {
            own = Math.max(lastOwn, lastNotOwn2 - price);
            notOwn = Math.max(lastNotOwn, lastOwn + price);

            lastNotOwn2 = lastNotOwn;
            lastNotOwn = notOwn;
            lastOwn = own;

            res = Math.max(res, Math.max(own, notOwn));
        }

        return res;
    }

    public int maxProfit(int[] prices) {
        return maxProfit2(prices);
    }
}

