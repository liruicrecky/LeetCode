/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null ? true : isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pNode1, TreeNode pNode2) {
        if (pNode1 == null && pNode2 == null) {
            return true;
        }
        if (pNode1 == null || pNode2 == null) {
            return false;
        }
        return pNode1.val == pNode2.val && isSymmetrical(pNode1.left, pNode2.right)
                && isSymmetrical(pNode1.right, pNode2.left);
    }
}