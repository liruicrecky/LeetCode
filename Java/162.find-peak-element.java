/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */
class Solution {

    private int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    private int findPeakElement1(int[] nums) {
        int index = 0;
        int len = nums.length;
        if (len == 1) { return index; }
        for (;index < len; index++) {
            if (index == 0 && index + 1 < len && nums[index] > nums[index + 1]) {
                break;
            } else if (index == len - 1 && index - 1 >= 0 && nums[index] > nums[index - 1]) {
                break;
            } else if (index >= 1 && index < len - 1 && nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
                break;
            }
        }

        return index;
    }

    public int findPeakElement(int[] nums) {
        return findPeakElement3(nums);
    }
}

