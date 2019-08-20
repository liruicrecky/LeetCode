class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int t = nums[nums[i] - 1];
                if (nums[i] == t) {
                    return t;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }

        return 0;
    }
}