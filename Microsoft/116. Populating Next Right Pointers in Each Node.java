/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node pre = null;
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            pre = null;
            for (int i = 0; i < size; i++) {
                Node n = que.poll();
                if (pre == null) {
                    pre = n;
                } else {
                    pre.next = n;
                    pre = n;
                }

                if (n.left != null) {
                    que.offer(n.left);
                }
                if (n.right != null) {
                    que.offer(n.right);
                }
            }
        }

        return root;
    }
}