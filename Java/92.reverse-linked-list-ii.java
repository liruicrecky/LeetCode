/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (34.12%)
 * Total Accepted:    187.4K
 * Total Submissions: 542.4K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode mHead = fakeHead, nEnd = fakeHead;
        while (m-- > 1) {
            mHead = mHead.next;
        }
        while (n-- >= 0) {
            nEnd = nEnd.next;
        }

        ListNode cur = mHead.next;
        ListNode pre = null;
        while (cur != nEnd) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        mHead.next = pre;
        ListNode it = pre;
        while (it.next != null) {
            it = it.next;
        }
        it.next = nEnd;

        return fakeHead.next;
    }
}

