/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (30.11%)
 * Likes:    1316
 * Dislikes: 589
 * Total Accepted:    300.7K
 * Total Submissions: 996.4K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */
class Solution {
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) { return; }

        int count = 1, start = 0;
        while (len >= count) {
            int cur = start, prev = nums[start];
            do {
                int next = (cur + k) % len;
                int t = nums[next];
                nums[next] = prev;
                prev = t;
                cur = next;
                ++count;
            } while (start != cur);
            ++start;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        help(nums, 0, nums.length - 1);
        help(nums, 0, k - 1);
        help(nums, k, nums.length - 1);     
    }

    private void help(int[] nums, int s, int e) {
        while (s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            ++s;
            --e;
        }
    }
}

