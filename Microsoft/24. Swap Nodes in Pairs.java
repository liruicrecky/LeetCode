/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;

        while (node.next != null && node.next.next != null) {
            ListNode first = node.next, second = node.next.next;
            first.next = second.next;
            second.next = first;
            node.next = second;
            node = first;
        }

        return dummy.next;
    }
}