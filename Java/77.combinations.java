import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (47.67%)
 * Likes:    781
 * Dislikes: 47
 * Total Accepted:    205.4K
 * Total Submissions: 428.6K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void help(List<List<Integer>> res, List<Integer> tmp, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start, max = n - k + 1; i <= max; i++) {
                tmp.add(i);
                help(res, tmp, i + 1, n, k - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }   
}

