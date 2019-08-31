/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> que = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                que.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (!que.isEmpty()) {
            node.next = que.poll();
            node = node.next;
            if (node.next != null) {
                que.offer(node.next);
            }
        }

        return dummy.next;
    }
}