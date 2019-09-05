class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int p = x, sum = 0;
        while (p > 0) {
            sum = sum * 10 + p % 10;
            p /= 10;
        }

        return sum == x;
    }
}