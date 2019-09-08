/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode> nodeQue = new ArrayDeque<>();
        ArrayDeque<Integer> numQue = new ArrayDeque<>();
        nodeQue.offer(root);
        numQue.offer(root.val);
        int sum = 0;

        while (!nodeQue.isEmpty()) {
            int size = nodeQue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = nodeQue.poll();
                int tmp = numQue.poll();
                if (n.left == null && n.right == null) {
                    sum += tmp;
                }

                if (n.left != null) {
                    nodeQue.offer(n.left);
                    numQue.offer(tmp * 10 + n.left.val);
                }
                if (n.right != null) {
                    nodeQue.offer(n.right);
                    numQue.offer(tmp * 10 + n.right.val);
                }
            }
        }

        return sum;
    }

    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int s) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return s * 10 + node.val;
        }

        return dfs(node.left, s * 10 + node.val) + dfs(node.right, s * 10 + node.val);
    }
}