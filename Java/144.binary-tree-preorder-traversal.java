/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (50.34%)
 * Total Accepted:    324.6K
 * Total Submissions: 637.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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

    private void preorderTraversal2(TreeNode root, List<Integer> res) {
        if (root == null) { return; }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            res.add(t.val);

            if (t.right != null) {
                s.push(t.right);
            }
            if (t.left != null) {
                s.push(t.left);
            }
        }
    }

    private void preorderTraversal1(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal1(root.left, res);
            preorderTraversal1(root.right, res);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal2(root, res);
        return res;
    }
}

