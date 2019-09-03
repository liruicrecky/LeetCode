class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
            --i;
        }

        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;
        while (j > i) {
            if (nums[j] > nums[i]) {
                swap(nums, i, j);
                break;
            }
            --j;
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}