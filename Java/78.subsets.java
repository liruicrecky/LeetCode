/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (51.16%)
 * Total Accepted:    337.9K
 * Total Submissions: 657.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), nums, 0);
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

