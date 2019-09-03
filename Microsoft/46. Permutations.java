class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), nums);
        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if (nums.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i])) {
                    continue;
                }

                tmp.add(nums[i]);
                backTrace(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}