/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        help(listNode, res);
        return res;
    }
    
    private void help(ListNode listNode, ArrayList<Integer> res) {
        if (listNode.next != null) {
            help(listNode.next, res);
        }
        res.add(listNode.val);
    }
}