package TwoPointersAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, Node> map;
    private final int maxCapacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.maxCapacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = node.next;
        nextNode.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private void addNode(Node node) {
        Node currHead = head.next;
        currHead.prev = node;
        node.next = currHead;
        node.prev = this.head;
        this.head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            deleteNode(existing);
            map.remove(key);
        } else if (map.size() == maxCapacity) {
            Node lru = tail.prev;
            deleteNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
    }
}
