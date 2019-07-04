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
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode cur = left;
        while (cur != null && cur.right != null) {
            cur = cur.right;
        }
        
        if (left != null) {
            pRootOfTree.left = cur;
            cur.right = pRootOfTree;
        }
        
        TreeNode right = Convert(pRootOfTree.right);
        cur = right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        
        if (right != null) {
            pRootOfTree.right = cur;
            cur.left = pRootOfTree;
        }
        
        return left == null ? pRootOfTree : left;
    }
    
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        
        TreeNode node = pRootOfTree;
        
        ArrayList<TreeNode> a = new ArrayList<>();
        Deque<TreeNode> s = new LinkedList<>();
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.addFirst(node);
                node = node.left;
            } else {
                node = s.removeFirst();
                a.add(node);
                node = node.right;
            }
        }
        
        for (int i = 0;i < a.size(); i++) {
            if (i != a.size() - 1) {
                a.get(i).right = a.get(i + 1);
            } else {
                a.get(i).right = null;
            }
            
            if (a.size() - i - 1 != 0) {
                a.get(a.size()- i - 1).left = a.get(a.size()- i - 2);
            } else {
                a.get(a.size()- i - 1).left = null;
            }
        }
        
        return a.get(0);
    }
}