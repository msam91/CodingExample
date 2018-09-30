package Apple;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    public Map<K, Node<K, V>> map = new HashMap<K, Node<K, V>>();
    int capacity;
    Node<K, V> head = null;
    Node<K, V> end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // If already present in map remove it from LIST
    // Make node as head
    public V get(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> oldNode = map.get(key);
            remove(oldNode);
            setHead(oldNode);
            return (V) oldNode.value;
        }

        return null;
    }

    // if present in map remove from list make it as HEAD
    // if not present in MAP there are two cases
    // 1. Map size is full : remove end node from map as well as list
    // 2. else make newNode as HEAD
    public void set(K key, V value) {

        if (map.containsKey(key)) {
            Node<K, V> oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        }
        else {

            Node<K, V> newNode = new Node<K, V>(key, value);
            map.put(key, newNode);
            if (map.size() > capacity) {
                map.remove(end.key);
                remove(end);
                setHead(newNode);
            }
            else {
                setHead(newNode);
            }
            map.put(key, newNode);
        }

    }

    // if any operation perform on the Node
    // Node is most recently use node
    // so remove the Node from List
    // Move back to head
    // 1. node can be at starting position //oldNode.prev == null
    // 2.node can be at middle // oldNode.prev != null
    // 3.node can be at end //oldNode.next ==null
    private void remove(Node<K, V> oldNode) {
        if (oldNode.prev != null) {
            oldNode.prev.next = oldNode.next;
        }
        else {
            head = head.next;
        }
        if (oldNode.next != null) {
            oldNode.next.prev = oldNode.prev;
        }
        else {
            end = oldNode.prev;
        }

    }

    // Once we remove the Node
    // We need to set node back to HEAD
    // Since it is recently used
    private void setHead(Node<K, V> newNode) {
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (end == null) {
            end = head;
        }

    }

}

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
