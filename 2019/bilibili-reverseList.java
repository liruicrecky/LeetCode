import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int v) {
            val = v;
            next = null;
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        int[] list = Arrays.stream(line.split("\\,")).mapToInt(Integer::parseInt).toArray();
        int len = list.length;
        ListNode head = new ListNode(-1), revHead = new ListNode(-2);
        ListNode node = head, revNode = revHead;

        for (int i = 0; i < len; i++) {
            node.next = new ListNode(list[i]);
            node = node.next;
        }

        for (int i = len - 1; i >= 0; i--) {
            revNode.next = new ListNode(list[i]);
            revNode = revNode.next;
        }

        node = head.next;
        revNode = revHead.next;

        for (int i = 0; i < (len >> 1); i++) {
            ListNode n = node.next, revN = revNode.next;
            node.next = revNode;
            revNode.next = n;
            node = n;
            revNode = revN;
        }

        node.next = null;
        if ((len & 1) == 0) {
            node = head.next;
            while (node.next != null && node.next.next != null) {
                node = node.next;
            }
            node.next = null;
        }

        node = head.next;
        while (node != null) {
            if (node.next == null) {
                System.out.printf("%d", node.val);
            } else {
                System.out.printf("%d,", node.val);
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split(",");
        sc.close();
        String[] res = new String[line.length];

        for (int i = 0; i < (line.length + 1) >> 1; i++) {
            res[i * 2] = line[i];
            if (i * 2 + 1 < line.length) {
                res[i * 2 + 1] = line[line.length - i - 1];
            }
        }

        System.out.println(String.join(",", res));
    }
}