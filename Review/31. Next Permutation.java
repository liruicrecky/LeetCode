class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length, i, j;
        if (len < 2) {
            return;
        }

        for (i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i == -1) {
            reverse(nums, 0, len - 1);
        } else {
            int t = nums[i];
            for (j = len - 1; j >= i; j--) {
                if (nums[j] > t) {
                    break;
                }
            }

            swap(nums, i, j);
            reverse(nums, i + 1, len - 1);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}