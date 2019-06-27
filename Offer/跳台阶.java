public class Solution {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[target] = 1;
        dp[target - 1] = 2;
        for (int i = target - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        
        return dp[1];
    }
}