/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node node = head;
        while (node != null) {
            Node n = node.next;
            node.next = new Node(node.val, null, null);
            node.next.next = n;
            node = n;
        }

        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        Node copyHead = node.next;
        Node copy = copyHead;
        while (copy.next != null) {
            node.next = node.next.next;
            node = node.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }

        node.next = node.next.next;

        return copyHead;
    }
}