/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode prev = null;
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if (prev != null && prev.val >= node.val) {
                    return false;
                }
                prev = node;
                node = node.right;
            }
        }

        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return help(root, null, null);
    }

    private boolean help(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }

        return (min == null || node.val > min.val) && (max == null || node.val < max.val) && help(node.left, min, node)
                && help(node.right, node, max);
    }
}