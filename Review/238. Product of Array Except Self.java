class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        int left = 1, right = 1;

        for (int i = 0; i < len; i++) {
            res[i] *= left;
            left *= nums[i];
            res[len - i - 1] *= right;
            right *= nums[len - i - 1];
        }

        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            right[len - i - 1] = nums[len - i] * right[len - i];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}