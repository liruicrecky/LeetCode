/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (64.49%)
 * Likes:    337
 * Dislikes: 19
 * Total Accepted:    45.3K
 * Total Submissions: 69.1K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given a n-ary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * We should return its max depth, which is 3.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth1(Node root) {
        if (root == null) { return 0; }
        int depth = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            ++depth;
            for (int i = 0; i < size; i++) {
                Node t = que.poll();
                for (Node n : t.children) {
                    que.offer(n);
                }
            }
        }

        return depth;
    }

    public int maxDepth(Node root) {
        if (root == null) { return 0; }
        int depth = 1;
        for (Node n : root.children) {
            depth = Math.max(depth, maxDepth(n) + 1);
        }

        return depth;
    }
}

