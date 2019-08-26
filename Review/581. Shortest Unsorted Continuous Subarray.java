class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int min = nums[len - 1], max = nums[0], begin = -1, end = -2;
        
        for (int i = 1;i < len;i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (max > nums[i]) {
                end = i;
            }
            
            if (min < nums[len - i - 1]) {
                begin = len - i - 1;
            }
        }
        
        return end - begin + 1;
    }
}