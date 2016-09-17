public class LRUCache {
    private int capacity;
    private Node head, tail;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            insertBefore(tail, node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            // move node to tail
            remove(node);
            insertBefore(tail, node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            insertBefore(tail, node);
        }
        if (cache.size() > capacity) {
            Node toRemove = head.next;
            if (toRemove == tail) return;
            cache.remove(toRemove.key);
            remove(toRemove);
        }
    }

    // remove node from double linked list
    private static void remove(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        node.prev = node.next = null;
    }

    // insert `node` before `tail`
    private static void insertBefore(Node tail, Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        if (node.prev != null) {
            node.prev.next = node;
        }
    }

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            value = v;
        }

        public Node() {
            this(0, 0);
        }
    }
}
