/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (59.31%)
 * Total Accepted:    483.6K
 * Total Submissions: 807.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
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

    private int maxDepth2(TreeNode root) {
        int mDepth = 0;
        if (root == null) { return mDepth; }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            ++mDepth;
            for (int i = 0; i < size; i++) {
                TreeNode t = que.poll();
                if (t.left != null) {
                    que.offer(t.left);
                }
                if (t.right != null) {
                    que.offer(t.right);
                }
            }
        }
        return mDepth;
    }

    private int maxDepth1(TreeNode root) {
        if (root == null) { return 0; }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        return maxDepth2(root);
    }
}

