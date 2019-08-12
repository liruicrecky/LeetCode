/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            res = slow;
        }

        return res;
    }
}