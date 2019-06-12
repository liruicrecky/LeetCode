/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (41.14%)
 * Likes:    1731
 * Dislikes: 49
 * Total Accepted:    226.7K
 * Total Submissions: 548.4K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return help(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, inorderMap);
    }

    private TreeNode help(int preStr, int preEnd, int inStr, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
        if (preStr > preEnd || inStr > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStr]);
        int inorderRoot = inorderMap.get(preorder[preStr]);
        int numLeft = inorderRoot - inStr;

        root.left = help(preStr + 1, preStr + numLeft, inStr, inorderRoot - 1, preorder, inorder, inorderMap);
        root.right = help(preStr + numLeft + 1, preEnd, inorderRoot + 1, inEnd, preorder, inorder, inorderMap);
        return root;
    }
}

