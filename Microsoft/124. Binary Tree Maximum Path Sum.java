/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        help(root, max);
        return max[0];
    }

    private int help(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, help(node.left, max));
        int right = Math.max(0, help(node.right, max));
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}