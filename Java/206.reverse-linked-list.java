/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (52.92%)
 * Total Accepted:    529.9K
 * Total Submissions: 997.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
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
    private ListNode reverseList1(ListNode head) {
        if (head == null) { return null; }
        ListNode p = null, c = head, n = null;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
    

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) { return head;}
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList(ListNode head) {
        return reverseList2(head);
    }
}

