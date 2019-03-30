/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (53.67%)
 * Total Accepted:    437.8K
 * Total Submissions: 812.7K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void moveZeroes2(int[] nums) {
        if (nums.length == 0) { return; }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ++count;
            } else if (count > 0) {
                swap(nums, i, i - count);  
            }
        }
    }

    private void moveZeroes1(int[] nums) {
        if (nums.length == 0) { return; }
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (; j < nums.length - count; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[j - 1] = 0;
                ++count;
            }
        }
    }
    
    public void moveZeroes(int[] nums) {
        moveZeroes2(nums);
    }
}

