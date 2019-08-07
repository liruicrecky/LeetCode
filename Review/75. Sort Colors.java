class Solution {
    public void sortColors(int[] nums) {
        int s = 0, e = nums.length - 1;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 0 && i > s) {
                nums[i] = nums[s];
                nums[s++] = 0;
            } else if (nums[i] == 2 && i < e) {
                nums[i] = nums[e];
                nums[e--] = 2;
            } else {
                ++i;
            }
        }
    }
}