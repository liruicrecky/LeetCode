/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (25.47%)
 * Likes:    2938
 * Dislikes: 104
 * Total Accepted:    302.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache*(2)
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
class LRUCache {

    class Node {
        
        int key;
        int val;

        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    int capacity, count;
    Node head, tail;
    Map<Integer, Node> m;


    public LRUCache(int capacity) {
       this.capacity = capacity;
       m = new HashMap<>(capacity);

       head = new Node(0, 0);
       tail = new Node(0, 0);

       head.next = tail;
       head.prev = null;
       tail.prev = head;
       tail.next = null;
       count = 0;
    }
    
    public int get(int key) {
        if (m.containsKey(key)) {
            Node n = m.get(key);
            deleteNode(n);
            addToHead(n);
            return n.val;
        }
      
        return -1;
    }
    
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node n = m.get(key);
            n.val = value;
            deleteNode(n);
            addToHead(n);
            return;
        } 

        Node n = new Node(key, value);
        if (m.size() == capacity) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        m.put(key, n);
        addToHead(n);
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

