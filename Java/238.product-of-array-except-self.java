/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (53.96%)
 * Total Accepted:    235.1K
 * Total Submissions: 433.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */
class Solution {
    private int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int left = 1, right = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            res[i] *= left;
            left *= nums[i];
            res[len - i - 1] *= right;
            right *= nums[len - i - 1];
        }
        return res;
    }
    public int[] productExceptSelf2(int[] nums) {
        if (nums.length == 0) { return new int[]{}; }
        int product = 1;
        boolean haveZero = false, haveZeroT = false;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else if (haveZero) {
                haveZeroT = true;
            } else {
                haveZero = true;
            }
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (haveZeroT || haveZero && nums[i] != 0) {
                res[i] = 0;
            } else if (nums[i] == 0) {
                res[i] = product;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        return productExceptSelf1(nums);
    }
}

