/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return help(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, inorderMap);
    }

    private TreeNode help(int preStr, int preEnd, int inStr, int inEnd, int[] preorder, int[] inorder,
            Map<Integer, Integer> inorderMap) {
        if (preEnd < preStr || inEnd < inStr) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStr]);
        int inorderRoot = inorderMap.get(preorder[preStr]);
        int leftNum = inorderRoot - inStr;
        root.left = help(preStr + 1, preStr + leftNum, inStr, inorderRoot - 1, preorder, inorder, inorderMap);
        root.right = help(preStr + leftNum + 1, preEnd, inorderRoot + 1, inEnd, preorder, inorder, inorderMap);
        return root;
    }
}