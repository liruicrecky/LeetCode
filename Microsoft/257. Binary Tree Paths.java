/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) {
            return;
        }
        int len = sb.length();

        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            dfs(node.left, res, sb);
            dfs(node.right, res, sb);
        }
        sb.setLength(len);
    }
}