/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head, n = head, node = head;
        boolean tillEnd = false, needNext = false;
        boolean isRever = false;

        while (cur != null) {
            if (n != null && n.next != null) {
                n = n.next.next;
            } else if (n != null && !tillEnd) {
                tillEnd = true;
                needNext = true;
            } else if (n == null) {
                tillEnd = true;
            }

            if (needNext) {
                cur = cur.next;
                needNext = false;
            }

            if (tillEnd) {
                if (!isRever) {
                    cur = reverseList(cur);
                    isRever = true;
                }

                if (cur != null && cur.val != node.val) {
                    return false;
                }

                node = node.next;
            }

            if (cur != null) {
                cur = cur.next;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = prev;
            prev = head;
            head = n;
        }

        return prev;
    }
}