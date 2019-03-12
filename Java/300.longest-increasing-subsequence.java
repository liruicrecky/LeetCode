/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (40.25%)
 * Total Accepted:    199.5K
 * Total Submissions: 495.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) { return 0; }
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int t = 0;
            while(j >= 0) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, memo[j]);
                }
                --j;
            }
            memo[i] = t + 1;
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}

