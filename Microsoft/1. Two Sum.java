class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {};
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (m.containsKey(left)) {
            } else {
                return new int[] { m.get(left), i };
                m.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}