/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        boolean trigger = true;
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (trigger) {
                    tmp.add(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    que.offer(node.left);
                }

                if (node.right != null) {
                    que.offer(node.right);
                }
            }

            if (trigger) {
                trigger = false;
            } else {
                trigger = true;
            }

            res.add(tmp);
        }

        return res;
    }
}