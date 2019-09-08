class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int cur = 2, pre = 1;
        for (int i = 3; i <= n; i++) {
            int t = cur;
            cur += pre;
            pre = t;
        }

        return cur;
    }
}