class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backTrace(res, tmp, candidates, remain - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}