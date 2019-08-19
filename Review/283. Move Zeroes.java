class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}