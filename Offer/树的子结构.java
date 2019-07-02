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
import java.util.LinkedList;
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean res = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root1);
        
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (res = help(t, root2)) {
                break;
            }
            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }
        }
        
        return res;
    }
    
    private boolean help(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null) {
            return false;
        }
        
        return t1.val == t2.val && help(t1.left, t2.left) && help(t1.right, t2.right);
    }
}