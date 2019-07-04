import java.util.ArrayList;
/**
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(res, new ArrayList<Integer>(), root, target, 0);
        return res;
    }
    
    private void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, TreeNode root, int target, int current) {
        current += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && target == current) {
            res.add(new ArrayList(tmp));
        }
        
        if (root.left != null) {
            help(res, tmp, root.left, target, current);
        }
        if (root.right != null) {
            help(res, tmp, root.right, target, current);
        }
        
        tmp.remove(tmp.size() - 1);
    }
}