/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode nextNode = fakeHead, preNode = fakeHead;
        while (n > 0) {
            nextNode = nextNode.next;
            --n;
        }
        
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            preNode = preNode.next;
        }
        
        // delete the node
        ListNode d = preNode.next;
        preNode.next = d.next;
        
        return fakeHead.next;
    }
}