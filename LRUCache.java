package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node {
        int key;
        int val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public class DoubleLinkedList {
        Node head;
        Node tail;
        public DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }
    }

    Map<Integer, Node> map;
    DoubleLinkedList linkedList;
    Node head, tail;
    int capacity = 0;
    int curSize = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new DoubleLinkedList();
        this.capacity = capacity;
        head = linkedList.head;
        tail = linkedList.tail;
    }

    public void addToHead(Node node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public Node removeTail() {
        Node pre = tail.pre;
        if (pre == head) {
            throw new IllegalArgumentException("There is no node to remove");
        }
        pre.pre.next = tail;
        tail.pre = pre.pre;
        return pre;
    }

    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            if (curSize < capacity) {
                map.put(key, node);
                addToHead(node);
                curSize++;
            } else {
                Node removeNode = removeTail();
                map.remove(removeNode.key);
                map.put(key, node);
                addToHead(node);
            }
        }
    }
}
