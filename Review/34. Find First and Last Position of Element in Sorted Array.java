class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (nums[mid] == target) {
                int l = mid, r = mid;
                while (l >= 0 && nums[l] == target) {
                    --l;
                }
                while (r < nums.length && nums[r] == target) {
                    ++r;
                }

                return new int[] { ++l, --r };
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}