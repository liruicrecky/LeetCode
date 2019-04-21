/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (40.56%)
 * Total Accepted:    209.5K
 * Total Submissions: 507.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) { return Collections.emptyList(); }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        boolean rev = false;

        while (!que.isEmpty()) {
            int size = que.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = que.poll();
                if (rev) {
                    list.addFirst(t.val);
                } else {
                    list.add(t.val);
                }

                if (t.left != null) {
                    que.offer(t.left);
                }
                if (t.right != null) {
                    que.offer(t.right);
                }
            }

            if (rev) {
                rev = false;
            } else {
                rev = true;
            }

            res.add(list);
        }

        return res;
    }
}

