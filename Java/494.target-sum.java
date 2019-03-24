/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (44.86%)
 * Total Accepted:    87.5K
 * Total Submissions: 194.8K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * ⁠
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.  
 * 
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array is positive and will not exceed 20. 
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */
class Solution {
    private int res = 0;

    private void brute(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) { ++res; }
        } else {
            brute(nums, i + 1, sum + nums[i], S);
            brute(nums, i + 1, sum - nums[i], S);
        }
    }

    private int memory(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S) { return 1; }
            else { return 0; }
        } else {
            if (memo[i][1000 + sum] != Integer.MIN_VALUE) {
                return memo[i][1000 + sum];
            }
            int plus = memory(nums, i + 1, sum + nums[i], S, memo);
            int sub = memory(nums, i + 1, sum - nums[i], S, memo);
            return memo[i][1000 + sum] = plus + sub;
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        // brute(nums, 0, 0, S);

        /*
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return memory(nums, 0, 0, S, memo);
        */
        return findTargetSumWays3(nums, S);
    }

    private int findTargetSumWays3(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) { sum += num; }
        if (sum < S || -sum > S) { return 0; }
        int[] dp = new int[(sum << 1) + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = new int[(sum << 1) + 1];
            for (int j = 0; j < (sum << 1) + 1; j++) {
                if (dp[j] != 0) {
                    tmp[j + nums[i]] += dp[j];
                    tmp[j - nums[i]] += dp[j];
                }
            }
            dp = tmp;
        }
        return dp[sum + S];
    }
}

