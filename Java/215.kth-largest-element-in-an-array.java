/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (46.16%)
 * Total Accepted:    338.5K
 * Total Submissions: 728.3K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    private int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int findKthLargest2(int[] nums, int k, int l, int h) {
        int s = l, e = h;
        int p = nums[s];

        while(s < e) {
            while (s < e && nums[e] > p) { --e; }
            if (s < e) { nums[s++] = nums[e]; }

            while (s < e && nums[s] < p) { ++s; }
            if (s < e) { nums[e--] = nums[s]; }
        }

        nums[s] = p;
        if (nums.length - s == k) { return nums[s]; }
        else if (nums.length - s > k) { return findKthLargest2(nums, k, s + 1, h); }
        else { return findKthLargest2(nums, k, l, s - 1); }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest2(nums, k, 0, nums.length - 1);
    }
}

