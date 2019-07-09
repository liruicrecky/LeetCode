/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = 0, len2 = 0;

        ListNode node = pHead1;
        while (node != null) {
            ++len1;
            node = node.next;
        }

        node = pHead2;
        while (node != null) {
            ++len2;
            node = node.next;
        }

        int diff = len1 - len2;
        while (diff > 0) {
            pHead1 = pHead1.next;
            --diff;
        }
        while(diff < 0) {
            pHead2 = pHead2.next;
            ++diff;
        }

        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }
}