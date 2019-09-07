/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode pre = null;
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (pre == null) {
                pre = node;
            } else {
                pre.left = null;
                pre.right = node;
                pre = node;
            }

            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

    }

    public void flatten1(TreeNode root) {
        help(root, null);
    }

    private TreeNode help(TreeNode node, TreeNode pre) {
        if (node == null) {
            return pre;
        }

        pre = help(node.right, pre);
        pre = help(node.left, pre);
        node.right = pre;
        node.left = null;
        pre = node;
        return pre;
    }
}