/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (34.05%)
 * Total Accepted:    174.3K
 * Total Submissions: 508K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
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
    public ListNode sortList1(ListNode head) {
        if (head == null) { return null; }
        ListNode node = head, next = null;
        while (node != null) {
            next = node.next;
            while (next != null) {
                if (next.val < node.val) {
                    int tmp = node.val;
                    node.val = next.val;
                    next.val = tmp;
                }
                next = next.next;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode smallStart = null, smallEnd = null;
            ListNode prev = head;
            for (ListNode p = head.next; p != tail; ) {
                if (p.val < head.val) {
                    if (smallStart == null) {
                        smallStart = p;
                        smallEnd = smallStart;
                    } else {
                        smallEnd.next = p;
                        smallEnd = smallEnd.next;
                    }
                    prev.next = p.next;
                } else {
                    prev = p;
                }
                p = p.next;
            }
            if (smallEnd == null) { return head; }
            smallEnd.next = head;
            head.next = sortList2(head.next, tail);
            head = sortList2(smallStart, head);
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
       return sortList2(head, null);
    }
}

