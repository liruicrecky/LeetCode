public class Solution {
    public int Fibonacci1(int n) {
        int[] memo = new int[n + 1];
        return help(n, memo);
    }
    
    private int help(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return memo[n] = help(n - 1, memo) + help(n - 2, memo);
        }
    }
    
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        
        int pp = 1, p = 1, cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pp + p;
            pp = p;
            p = cur;
        }
        
        return cur;
    }
}