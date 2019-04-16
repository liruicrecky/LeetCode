/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.37%)
 * Total Accepted:    251.4K
 * Total Submissions: 794.5K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {

    private boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }

    private boolean canJump1(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length && jump[i + j] == true) {
                    jump[i] = true;
                    break;
                }
            }
        }

        return jump[0];
    }

    public boolean canJump(int[] nums) {
        return canJump2(nums);
    }
}

