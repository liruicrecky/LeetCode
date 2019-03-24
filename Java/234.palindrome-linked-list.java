/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.38%)
 * Total Accepted:    238.9K
 * Total Submissions: 673.1K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode t = node.next;
            node.next = prev;
            prev = node;
            node = t;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode c = head, n = head, l = head;
        boolean find = false, needNext = false;
        boolean re = false;
        while (c != null) {
            if (n != null && n.next != null) {
                n = n.next.next;
            } else if (n != null && !find) {
                find = true;
                needNext = true;
            } else if (n == null) {
                find = true;
            }
            if (needNext) {
                c = c.next;
                needNext = false;
            }
            if (find) {
                if (!re) {
                    c = reverse(c);
                    re = true;
                }
                if (c != null && c.val != l.val) {
                    return false;
                }
                l = l.next;
            }
            if (c != null)
                c = c.next;
        }
        return true;
    }
}

