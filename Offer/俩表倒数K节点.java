/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode cur = head, nextK = head;
        for (int i = 0; i < k - 1; i++) {
            nextK = nextK.next;
            if (nextK == null && i < k) {
                return null;
            }
        }
        
        while(nextK.next != null) {
            cur = cur.next;
            nextK = nextK.next;
        }
        
        return cur;
    }
}