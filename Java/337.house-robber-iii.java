/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (47.40%)
 * Total Accepted:    95.9K
 * Total Submissions: 201.7K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3,null,3,null,1]
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \ 
 * ⁠    3   1
 * 
 * Output: 7 
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,5,1,3,null,1]
 * 
 * 3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \ 
 * ⁠1   3   1
 * 
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
    private int include(TreeNode node) {
        if (node == null) { return 0; }
        return node.val + exClude(node.left) + exClude(node.right);
    }

    private int exClude(TreeNode node) {
        if (node == null) { return 0; }
        return rob(node.left) + rob(node.right);
    }

    // TODO need to fix
    private int help(TreeNode root, boolean canRobbed) {
        if (root == null) { return 0; }
        if (root.left == null && root.right == null && canRobbed) { return root.val; }
        if (root.left == null && root.right == null && !canRobbed) { return 0; }
        if (root.left == null || root.right == null) { 
            if (canRobbed) {
                return root.left == null ? Math.max(root.val, root.right.val)
                    : Math.max(root.val, root.left.val);
            } else {
                return root.left == null ? root.right.val : root.left.val;
            }   
         }
        
        if (canRobbed) {
            return Math.max(root.val + help(root.left, false) + help(root.right, false), 
                        help(root.left, true) + help(root.right, true));
        } 

        return help(root.left, true) + help(root.right, true); 
    }

    public int rob(TreeNode root) {
        if (root == null) { return 0; }
        return Math.max(include(root), exClude(root));
    }
}

