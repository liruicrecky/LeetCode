/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private ListNode getMidListNode(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    private TreeNode sortedListToBST1(ListNode head) {
        if (head == null) { return null; }

        ListNode mid = getMidListNode(head);
        TreeNode root = new TreeNode(mid.val);

        if (mid == head) {
            return root;
        }

        root.left = sortedListToBST1(head);
        root.right = sortedListToBST1(mid.next);

        return root;
    }

    private List<Integer> convertListToArray(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

    private TreeNode sortedListToBST2(List<Integer> arr, int left, int right) {
        if (left > right) { return null; }

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(arr.get(mid));

        if (left == right) {
            return root;
        }

        root.left = sortedListToBST2(arr, left, mid - 1);
        root.right = sortedListToBST2(arr, mid + 1, right);

        return root;
    }

    private ListNode head;

    private int getSizeOfListnode(ListNode head) {
        int res = 0;
        while (head != null) {
            ++res;
            head = head.next;
        }
        return res;
    }

    private TreeNode sortedListToBST3(int lefeIndex, int rightIndex) {
        if (lefeIndex > rightIndex) { return null; }

        int mid = (lefeIndex + rightIndex) >> 1;
        TreeNode left = sortedListToBST3(lefeIndex, mid - 1);

        TreeNode node = new TreeNode(head.val);
        node.left = left;

        head = head.next;

        node.right = sortedListToBST3(mid + 1, rightIndex);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        // return sortedListToBST1(head);

        // List<Integer> arr = convertListToArray(head);
        // return sortedListToBST2(arr, 0, arr.size() - 1);

        this.head = head;
        int size = getSizeOfListnode(head);
        return sortedListToBST3(0, size - 1);
    }
}

