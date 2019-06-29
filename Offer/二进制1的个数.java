public class Solution {
    public int NumberOf2(int n) {
        int count = 0;
        int i = 0;
        while (i != 32) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>= 1;
            ++i;
        }
        return count;
    }
    
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }
}