public class Solution {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } 
        
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        
        return dp[target];
    }
}