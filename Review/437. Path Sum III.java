/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[] { 0 };
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            help(node, sum, res);

            if (node.left != null) {
                que.offer(node.left);
            }

            if (node.right != null) {
                que.offer(node.right);
            }
        }

        return res[0];
    }

    private void help(TreeNode node, int sum, int[] count) {
        if (node == null) {
            return;
        }

        if (sum - node.val == 0) {
            count[0]++;
        }

        if (node.left != null) {
            help(node.left, sum - node.val, count);
        }

        if (node.right != null) {
            help(node.right, sum - node.val, count);
        }
    }
}