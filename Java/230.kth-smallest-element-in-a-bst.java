/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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

    private void help(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        help(root.left, l);
        l.add(root.val);
        help(root.right, l);
    }

    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        help(root, l);
        return l.get(k - 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        int res = 0;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if (k == 1) {
                    res = node.val;
                    break;
                }

                node = node.right;
                --k;
            }
        }
        
        return res;
    }
}

