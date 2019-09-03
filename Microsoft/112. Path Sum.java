/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode node, int remain) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return remain == node.val;
        }

        return dfs(node.left, remain - node.val) || dfs(node.right, remain - node.val);
    }
}