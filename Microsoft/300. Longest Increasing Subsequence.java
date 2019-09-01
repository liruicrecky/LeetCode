class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int s = 0, e = len;
            while (s != e) {
                int m = (s + e) >>> 1;
                if (num > lis[m]) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }

            lis[s] = num;
            if (s == len) {
                ++len;
            }
        }

        return len;
    }
}