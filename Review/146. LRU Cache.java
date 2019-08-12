class LRUCache {

    class Node {
        int key;
        int val;

        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> m;
    private Node head = null, tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>(capacity);

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            deleteNode(node);
            addToHead(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
            return;
        }

        Node node = new Node(key, value);
        if (m.size() == capacity) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        m.put(key, node);
        addToHead(node);
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
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */