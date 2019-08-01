/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode resH = new ListNode(0);
        ListNode node = resH;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
           
            carry = sum >= 10 ? sum / 10 : 0;
            sum %= 10;
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        
        return resH.next;
    }
}