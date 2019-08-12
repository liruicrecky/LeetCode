class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0], tMaxP = maxP, tMinP = maxP;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int t = tMaxP;
                tMaxP = tMinP;
                tMinP = t;
            }

            tMaxP = Math.max(num, num * tMaxP);
            tMinP = Math.min(num, num * tMinP);
            maxP = Math.max(maxP, tMaxP);
        }

        return maxP;
    }
}