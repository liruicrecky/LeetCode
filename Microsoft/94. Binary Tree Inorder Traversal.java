/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // help(root, res);
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    private void help(TreeNode node, List<Integer> res) {
        if (node != null) {
            help(node.left, res);
            res.add(node.val);
            help(node.right, res);
        }
    }
}