/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root, prev = null;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if (node.right != null && node.right != prev) {
                    s.push(node);
                    node = node.right;
                    continue;
                }

                res.add(node.val);
                prev = node;
                node = null;
            }
        }

        return res;
    }
}