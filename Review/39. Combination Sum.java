class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backTrace(res, tmp, candidates, i, target - candidates[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}