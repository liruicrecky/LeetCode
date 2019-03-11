import java.util.Arrays;

/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (35.10%)
 * Total Accepted:    107.2K
 * Total Submissions: 305.4K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */
class Solution {
    private int rob1(int[] nums) {
        if (nums.length == 0) { return 0; }
        else if (nums.length == 1) { return nums[0]; }
        int withOnePre1 = 0;
        int withOnePre2 = 0;
        int withoutOnePre1 = 0;
        int withoutOnePre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( i != nums.length - 1) {
                int t = withOnePre1;
                withOnePre1 = Math.max(withOnePre1, nums[i] + withOnePre2);
                withOnePre2 = t;
            }
            if ( i != 0) {
                int t = withoutOnePre1;
                withoutOnePre1 = Math.max(withoutOnePre1, nums[i] + withoutOnePre2);
                withoutOnePre2 = t;
            }
        }
        return Math.max(withOnePre1, withoutOnePre1);
    }

    public int rob(int[] nums) {
        return rob1(nums);
    }
}

