/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        help1(res, root);
        return res;
    }

    private void help(List<Integer> res, TreeNode root) {
        if (root != null) {
            help(res, root.left);
            res.add(root.val);
            help(res, root.right);
        }
    }

    private void help1(List<Integer> res, TreeNode root) {
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
    }
}