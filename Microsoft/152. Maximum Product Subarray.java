class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxP = nums[0], tmax = nums[0], tmin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int t = tmax;
                tmax = tmin;
                tmin = t;
            }

            tmax = Math.max(num, tmax * num);
            tmin = Math.min(num, tmin * num);
            maxP = Math.max(maxP, tmax);
        }

        return maxP;
    }
}