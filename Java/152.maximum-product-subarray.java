/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (28.56%)
 * Total Accepted:    191.7K
 * Total Submissions: 670.5K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0];
        int tmaxP = nums[0];
        int tminP = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { 
                int t = tmaxP;
                tmaxP = tminP;
                tminP = t;
            }
            tmaxP = Math.max(nums[i], nums[i] * tmaxP);
            tminP = Math.min(nums[i], nums[i] * tminP);
            if (tmaxP > maxP) { maxP = tmaxP; }
        }
        return maxP;
    }
}

