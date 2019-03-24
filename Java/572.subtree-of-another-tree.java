/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (41.30%)
 * Total Accepted:    91.4K
 * Total Submissions: 220.7K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private String help1(TreeNode node, boolean l) {
        if (node == null) {
            if (l) {
                return "lnull";
            } else {
                return "rnull";
            }
        }
        return "#" + node.val + help1(node.left, true) + help1(node.right, false);
    } 
    
    private boolean help2(TreeNode node, TreeNode t) {
        if (node == null && t == null) { return true; }
        if (node == null || t == null) { return false; }
        return node.val == t.val && help2(node.left, t.left) && help2(node.right, t.right);
    }

    private boolean help3(TreeNode s, Treenode t) {
        return s != null && (help2(s, t) || help3(s.left, t) || help3(s.right, t));
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        /*
        String ps = help1(s, true);
        String ts = help1(t, true);
        return ps.indexOf(ts) >= 0;
        */
        boolean ans = false;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(s);
        while (!que.isEmpty()) {
            TreeNode tmp = que.poll();
            ans = help2(tmp, t);
            if (ans) { break; }
            if (tmp.left != null) {
                que.offer(tmp.left);
            }
            if (tmp.right != null) {
                que.offer(tmp.right);
            }
        }
        return ans;
    }
}

