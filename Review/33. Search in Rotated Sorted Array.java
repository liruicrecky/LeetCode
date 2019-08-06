class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[s]) {
                if (target >= nums[s] && target <= nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[e] >= nums[mid]) {
                if (target >= nums[mid] && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return -1;
    }
}