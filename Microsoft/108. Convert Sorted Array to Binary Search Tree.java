/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }

        int mid = (s + e) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, s, mid - 1);
        root.right = help(nums, mid + 1, e);
        return root;
    }
}