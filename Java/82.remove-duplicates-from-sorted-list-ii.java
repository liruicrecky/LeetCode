/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode prev = fakeHead, cur = head;
        while (cur != null) {  
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        return fakeHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) { return null; }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }
}

