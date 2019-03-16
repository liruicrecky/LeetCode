/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.70%)
 * Total Accepted:    346.6K
 * Total Submissions: 645.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        help(nums, new LinkedList<>(), res);
        return res;
    }
    private void help(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i])) {
                    continue;
                }
                tmp.add(nums[i]);
                help(nums, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

