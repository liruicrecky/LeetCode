class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            int l = num - 1;
            int r = num + 1;
            while (set.remove(l)) {
                --l;
            }
            while (set.remove(r)) {
                ++r;
            }
            res = Math.max(res, r - l - 1);
            if (set.isEmpty()) {
                break;
            }
        }

        return res;
    }
}