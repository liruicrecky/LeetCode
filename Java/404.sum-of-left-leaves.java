/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) { return 0; }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int res = 0;

        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            if (t.left != null) {
                if (t.left.left == null && t.left.right == null) {
                    res += t.left.val;
                } else {
                    s.push(t.left);
                }
            }

            if (t.right != null) {
                if (t.right.left != null || t.right.right != null) {
                    s.push(t.right);
                }
            }
        }

        return res;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }

        res += sumOfLeftLeaves(root.right);
        return res;
    }
}
