class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >>> 1] + (i & 1);
        }

        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int count = 0, t = i;
            while (t > 0) {
                if ((t & 1) == 1) {
                    ++count;
                }
                t >>>= 1;
            }
            res[i] = count;
        }

        return res;
    }
}