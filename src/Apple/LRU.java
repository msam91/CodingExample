package Apple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

class LRU {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String args[]) {

        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(3);

    }

    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = null;
    private Node end = null;
    private int capacity = 0;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            removeNode(oldNode);
            setHead(oldNode);
            return oldNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.value = value;
            map.put(key, oldNode);
            removeNode(oldNode);
            setHead(oldNode);
        }
        else {
            Node newNode = new Node(key, value);
            if (map.size() < capacity) {
                setHead(newNode);
            }
            else {
                map.remove(end.key);
                removeNode(end);
            }
            map.put(key, newNode);
        }
    }

    public void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            end = node.prev;
        }
    }

    public void setHead(Node node) {

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (end == null) {
            end = head;
            
        }

    }

}
