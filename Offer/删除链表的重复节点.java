/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
// 1->2->3->3->4->4->5 
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = pHead;

        ListNode node = fakeHead, n = node.next;
        while (n != null) {
            if (n.next != null && n.val == n.next.val) {
                while (n.next != null && n.val == n.next.val) {
                    n = n.next;
                }

                node.next = n.next;
                n = n.next;
            } else {
                node = n;
                n = n.next;
            }
        }

        return fakeHead.next;
    }
}