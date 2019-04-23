/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) { return Collections.emptyList(); }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> tList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode t = que.poll();
                tList.add(t.val);
                if (t.left != null) {
                    que.offer(t.left);
                }
                if (t.right != null) {
                    que.offer(t.right);
                }
            }

            res.add(tList);
        }

        Collections.reverse(res);
        return res;
    }
}

