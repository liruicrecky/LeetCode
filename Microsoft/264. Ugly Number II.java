class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }

        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            ugly[i] = min;
            if (min == ugly[i2] * 2) {
                ++i2;
            }
            if (min == ugly[i3] * 3) {
                ++i3;
            }
            if (min == ugly[i5] * 5) {
                ++i5;
            }
        }

        return ugly[n - 1];
    }
}