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
import java.util.Stack;
public class Solution {
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
    
    public void Mirror1(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = t;
            if (t.left != null) {
                s.push(t.left);
            }
            if (t.right != null) {
                s.push(t.right);
            }
        }
    }
}