/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        clone(pHead);
        cloneRandom(pHead);
        return dul(pHead);
    }
    
    private void clone(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode n = new RandomListNode(node.label);
            n.next = node.next;
            node.next = n;
            node = n.next;
        }
    }
    
    private void cloneRandom(RandomListNode pHead) {
        RandomListNode n = pHead;
        while (n != null) {
            RandomListNode c = n.next;
            if (n.random != null) {
                c.random = n.random.next;
            }
            n = c.next;
        }
    }
    
    private RandomListNode dul(RandomListNode pHead) {
        RandomListNode n = pHead;
        RandomListNode cloneHead = null, node = null;
        cloneHead = node = pHead.next;
        n.next = node.next;
        n = n.next;


        while (n != null) {
            node.next = n.next;
            node = node.next;
            n.next = node.next;
            n = n.next;
        }
        return cloneHead;
    }
}