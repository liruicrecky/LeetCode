/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Map<Integer, Integer> m = new HashMap<>(in.length);
        for (int i = 0; i < in.length; i++) {
            m.put(in[i], i);
        }
        
        return help(0, pre.length - 1, pre, 0, in.length - 1, in, m);
    }
    
    private TreeNode help(int ps, int pe, int[] pre, int is, int ie, int[] in, Map<Integer, Integer> m) {
        if (ps > pe || is > ie) {
            return null;
        }
        
        int inRoot = m.get(pre[ps]);
        int inLeft = inRoot - is;
        TreeNode root = new TreeNode(pre[ps]);
        root.left = help(ps + 1, ps + inLeft, pre, is, inRoot - 1, in, m);
        root.right = help(ps + inLeft + 1, pe, pre, inRoot + 1, ie, in, m);
        
        return root;   
    }
}