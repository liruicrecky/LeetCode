/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        help(root, new int[] { 0 });
        return root;
    }

    private void help(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }

        help(node.right, sum);
        node.val += sum[0];
        sum[0] = node.val;
        help(node.left, sum);
    }
}