class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0, len = nums.length;
        for (int i = 0; i < len && maxReach < len && i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return maxReach >= len - 1;
    }
}