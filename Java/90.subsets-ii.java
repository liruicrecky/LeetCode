/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (41.52%)
 * Total Accepted:    191.5K
 * Total Submissions: 460.1K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backTrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int s) {
        res.add(new ArrayList<>(tmp));
        for (int i = s; i < nums.length; i++) {
            if (i > s && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backTrace(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

