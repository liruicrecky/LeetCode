public class Solution {
    public int RectCover(int target) {
        int[] memo = new int[target + 1];
        return help(memo, target);
    }
    
    private int help(int[] memo, int target) {
        if (memo[target] > 0) {
            return memo[target];
        }
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        
        return memo[target] = help(memo, target - 1) + help(memo, target - 2);
    }
}]