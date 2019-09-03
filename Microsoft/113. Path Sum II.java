/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> tmp, TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        tmp.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(tmp));
        } else {
            backTrace(res, tmp, node.left, sum - node.val);
            backTrace(res, tmp, node.right, sum - node.val);
        }
        tmp.remove(tmp.size() - 1);
    }
}