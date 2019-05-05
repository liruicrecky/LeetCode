/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange1(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int[] res = new int[] {-1, -1};
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (nums[mid] == target) {
                int rs = mid, re = mid;
                while (rs >= 0 && nums[rs] == target) {
                    --rs;
                }
                while (re < nums.length && nums[re] == target) {
                    ++re;
                }
                res[0] = rs + 1;
                res[1] = re - 1;
                break;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }

    private int help(int[] nums, int target, boolean left) {
        int s = 0, e = nums.length;
        while (s < e) {
            int mid = (s + e) >> 1;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };

        int left = help(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return res;
        }

        res[0] = left;
        res[1] = help(nums, target, false) - 1;

        return res;
    }
}

