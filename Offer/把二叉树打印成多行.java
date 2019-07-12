import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        que.offer(pRoot);

        while (!que.isEmpty()) {
            int len = que.size();
            ArrayList<Integer> tmpArr = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                TreeNode t = que.poll();
                tmpArr.add(t.val);

                if (t.left != null) {
                    que.offer(t.left);
                }

                if (t.right != null) {
                    que.offer(t.right);
                }
            }
            res.add(tmpArr);
        }

        return res;
    }

}