/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class Solution {

    private int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num, t = 1;
                while (set.contains(curNum + 1)) {
                    ++curNum;
                    ++t;
                }

                res = Math.max(res, t);
            }
        }

        return res;
    }

    private int longestConsecutive1(int[] nums) {
        if (nums.length == 0) { return 0; }
        Arrays.sort(nums);
        int res = 1, cur = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                ++cur;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        return Math.max(res, cur);
    }

    public int longestConsecutive(int[] nums) {
        return longestConsecutive2(nums);
    }
}

