/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (42.85%)
 * Total Accepted:    368.9K
 * Total Submissions: 860.5K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    private boolean help1(TreeNode root) {
        if (root == null) { return true; }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode t1 = que.poll();
            TreeNode t2 = que.poll();
            if (t1 == null && t2 == null) { continue; }
            if (t1 == null || t2 == null) { return false; }
            if (t1.val != t2.val) { return false; }
            que.offer(t1.left);
            que.offer(t2.right);
            que.offer(t1.right);
            que.offer(t2.left);
        }
        return true;
    }
    private boolean help(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { return true; }
        if (t1 == null || t2 == null) { return false; }
        return t1.val == t2.val && help(t1.left, t2.right) && help(t1.right, t2.left);
    }
    public boolean isSymmetric(TreeNode root) {
       return help1(root);
    }
}

