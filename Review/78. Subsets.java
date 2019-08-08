class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int s) {
        res.add(new ArrayList<>(tmp));
        for (int i = s; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrace(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}