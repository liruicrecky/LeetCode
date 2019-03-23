/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (42.03%)
 * Total Accepted:    96.1K
 * Total Submissions: 228.1K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        /*
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode t = que.poll();
            backTrace(t, sum);
            if (t != null && t.left != null) {
                que.offer(t.left);
            }
            if (t != null && t.right != null) {
                que.offer(t.right);
            }
        }
        return count;
        */
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        return help(root, 0, sum, m);
    }

    private void backTrace(TreeNode node, int remain) {
        if (node == null) { return; }
        if (remain - node.val == 0) { ++count; }
        if (node.left != null) {
            backTrace(node.left, remain - node.val);
        }
        if (node.right != null) {
            backTrace(node.right, remain - node.val);
        }
    }

    private int help(TreeNode node, int curSum, int tarSum, Map<Integer, Integer> m) {
        if (node == null) { return 0; }
        curSum += node.val;
        int res = m.getOrDefault(curSum - tarSum, 0);

        m.put(curSum, m.getOrDefault(curSum, 0) + 1);
        res += help(node.left, curSum, tarSum, m) + help(node.right, curSum, tarSum, m);
        m.put(curSum, m.get(curSum) - 1);

        return res;
    }
}

