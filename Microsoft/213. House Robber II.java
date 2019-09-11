class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int prevMax1 = 0, curMax1 = 0;
        int prevMax2 = 0, curMax2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                int t = curMax1;
                curMax1 = Math.max(curMax1, prevMax1 + nums[i]);
                prevMax1 = t;
            }

            if (i != nums.length - 1) {
                int t = curMax2;
                curMax2 = Math.max(curMax2, prevMax2 + nums[i]);
                prevMax2 = t;
            }
        }

        return Math.max(curMax1, curMax2);
    }
}