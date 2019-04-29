/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int res = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] >= nums[s]) {
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[e] >= nums[mid]) {
                if (target > nums[mid] && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return res;
    }
}

