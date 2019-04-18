/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (55.19%)
 * Total Accepted:    439.5K
 * Total Submissions: 785.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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

    private void inorderTraversal2(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;

        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
    }

    private void inorderTraversal1(TreeNode root, List<Integer> ans) {
        if (root != null) {
            inorderTraversal1(root.left, ans);
            ans.add(root.val);
            inorderTraversal1(root.right, ans);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal2(root, ans);
        return ans;
    }
}

