import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode t = que.poll();
            int left = getHeight(t.left);
            int right = getHeight(t.right);
            if (Math.abs(left - right) > 1) {
                return false;
            }

            if (t.left != null) {
                que.offer(t.left);
            }

            if (t.right != null) {
                que.offer(t.right);
            }
        }

        return true;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}