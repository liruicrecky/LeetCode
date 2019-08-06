/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pri = new PriorityQueue<>(lists.length, (l1, l2) -> l1.val - l2.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                pri.add(list);
            }
        }

        while (!pri.isEmpty()) {
            tail.next = pri.poll();
            tail = tail.next;

            if (tail.next != null) {
                pri.add(tail.next);
            }
        }

        return dummy.next;
    }
}