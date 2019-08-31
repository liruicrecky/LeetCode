/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }

        return prev;
    }
}