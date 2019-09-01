/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        /*
         * if (root == null) { return true; }
         * 
         * int left = depth(root.left); int right = depth(root.right);
         * 
         * return Math.abs(left - right) <= 1 && isBalanced(root.left) &&
         * isBalanced(root.right);
         */
        return help(root) != -1;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = help(node.left);
        int right = help(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return Math.max(left, right) + 1;
    }
}