class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[prev];
                nums[prev] = t;
                ++prev;   
            }
        }
    }
}