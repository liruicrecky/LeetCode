/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode t = que.poll();
            res.add(t.val);
            if (t.left != null) {
                que.offer(t.left);
            }
            if (t.right != null) {
                que.offer(t.right);
            }
        }
        return res;
    }
}