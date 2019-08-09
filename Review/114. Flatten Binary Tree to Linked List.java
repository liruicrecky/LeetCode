/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    public TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }

        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        TreeNode pre = null;

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (pre == null) {
                pre = node;
            } else {
                pre.right = node;
                pre.left = null;
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
}