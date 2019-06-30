/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        
        return fakeHead.next;
    }
}