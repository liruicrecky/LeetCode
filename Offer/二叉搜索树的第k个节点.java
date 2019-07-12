import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        ArrayDeque<TreeNode> aque = new ArrayDeque<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        TreeNode p = pRoot;

        while (p != null || !aque.isEmpty()) {
            if (p != null) {
                aque.push(p);
                p = p.left;
            } else {
                p = aque.pop();
                arr.add(p);
                p = p.right;
            }
        }

        return k > arr.size() ? null : arr.get(k - 1);
    }

}