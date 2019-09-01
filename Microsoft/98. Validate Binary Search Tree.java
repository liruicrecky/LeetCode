/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        double prev = -Double.MAX_VALUE;
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if (prev >= node.val) {
                    return false;
                }
                prev = node.val;
                node = node.right;
            }
        }

        return true;
    }
}