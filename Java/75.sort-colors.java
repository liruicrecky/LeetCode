/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (41.40%)
 * Total Accepted:    305.2K
 * Total Submissions: 731.1K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {

    public void sortColors2(int[] nums) {
        int s = 0, e = nums.length - 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && i > s) {
                nums[i] = nums[s];
                nums[s++] = 0;
            } else if (nums[i] == 2 && i < e) {
                nums[i] = nums[e];
                nums[e--] = 2;
            } else {
                ++i;
            }
        }
    }
    
    private void sortColors1(int[] nums, int start, int end) {
        if (start > end) { return; }
        int p = nums[start];
        int s = start, e = end;
        while (s < e) {
            while (s < e && nums[e] > p) { --e; }
            if (s < e) {
                nums[s++] = nums[e];
            }
            while (s < e && nums[s] < p) { ++s; }
            if (s < e) {
                nums[e--] = nums[s];
            }
        }
        nums[s] = p;
        sortColors1(nums, start, s - 1);
        sortColors1(nums, s + 1, end);
    }

    public void sortColors(int[] nums) {
        sortColors2(nums);
    }
}

