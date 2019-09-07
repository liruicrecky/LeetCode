/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum > 9 ? 1 : 0;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }

        dummy.next = reverse(dummy.next);
        return dummy.next;
    }

    public ListNode reverse(ListNode list) {
        if (list == null) {
            return null;
        }

        ListNode prev = null, node = list;
        while (node != null) {
            ListNode n = node.next;
            node.next = prev;
            prev = node;
            node = n;
        }

        return prev;
    }
}