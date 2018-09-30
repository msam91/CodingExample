package goldManSachs;

import java.util.ArrayList;
import java.util.List;

public class HashMapImpl<K, V> {

    class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

    }

    private int capacity = 20;
    List<Node> buckets = null;

    public HashMapImpl() {
        buckets = new ArrayList<Node>(capacity);
        for(int i=0;i<capacity;i++){
            buckets.add(null);
        }
    }

    public HashMapImpl(int capacity) {
        buckets = new ArrayList<Node>(capacity);
        for(int i=0;i<capacity;i++){
            buckets.add(null);
        }
    }

    public void put(K k, V v) {
        Node n = getNodeWithKey(k);
        if (n != null) {
            n.value = v;
        }
        else {
            int index = getHash(k);
            Node oldNode = buckets.get(index);
            Node newNode = new Node(k, v);
            if (oldNode != null) {
                newNode.next = oldNode;
            }
            buckets.set(index, newNode);

        }
    }

    public V get(K k) {
        Node n = getNodeWithKey(k);
        if (n != null) {
            return n.value;
        }
        return null;

    }

    private Node getNodeWithKey(K k) {
        int bucket = getHash(k);
        Node curr = buckets.get(bucket);
        while (curr != null) {
            if (curr.key.equals(k)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private int getHash(K k) {
       int hash=  k.hashCode() % this.capacity-1;
       return hash;
    }

    public static void main(String args[]) {
        HashMapImpl<String, Integer> map = new HashMapImpl<String, Integer>();
        map.put("MANAS", 123);
        System.out.print(map.get("MANAS"));
        
        map.put("MANAS", 321);
        System.out.print(map.get("MANAS"));

    }

}
