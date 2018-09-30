package ThumbTack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap<K, V> {

    Map<K, Set<V>> multiMap = new HashMap<K, Set<V>>();
    Map<V, List<K>> cache = new HashMap<V, List<K>>();

    public void put(K k, V v) {
        Set<V> temp = null;
        if (!multiMap.containsKey(k)) {
            temp = new HashSet<V>();
        }
        else if (multiMap.containsKey(k) && !multiMap.get(k).contains(v)) {
            temp = multiMap.get(k);
        }
        if (temp != null) {
            temp.add(v);
            multiMap.put(k, temp);
            addTocache(k, v);
        }
        else{
            System.out.println("no op");
        }
    }

    public Collection<V> get(K k) {
        if (multiMap.containsKey(k)) {
            return multiMap.get(k);
        }
        return Collections.EMPTY_LIST;

    }

    void delete(K k, V v) {
        Set<V> temp = null;
        if (multiMap.containsKey(k) && multiMap.get(k).contains(v)) {
            temp = multiMap.get(k);
            temp.remove(v);
            if (temp.isEmpty()) {
                temp = null;
                multiMap.remove(k);
            }
            else {
                multiMap.put(k, temp);
            }
            removeFromCache(k, v);
        }
        System.out.println("no op");
    }

    boolean containsValue(V v) {
        return cache.containsKey(v);
    }

    public void addTocache(K k, V v) {
        List<K> keyList = null;
        if (!cache.containsKey(v)) {
            keyList = new ArrayList<K>();
        }
        else {
            keyList = cache.get(v);
        }
        keyList.add(k);
        cache.put(v, keyList);
    }

    public void removeFromCache(K k, V v) {
        List<K> keyList = cache.get(v);
        if (keyList.contains(k)) {
            keyList.remove(k);
        }
        if (keyList.isEmpty()) {
            keyList = null;
            cache.remove(v);
        }

    }
   

    @Override
    public String toString() {
        return "MultiMap [multiMap=" + multiMap + ", cache=" + cache + "]";
    }

    public static void main(String args[]) {
        MultiMap<String, String> m = new MultiMap<String, String>();
        m.put("k1", "v1");
        m.put("k1", "v2");
        m.put("k1", "v3");
        m.put("k2", "v3");
        m.put("k2", "v5");
        m.put("k3", "v5");
        m.put("k3", "v7");

        m.put("k1", "v1");
        m.put("k1", "v4");
        
        m.delete("k4", "v8");
        
        System.out.println(m.multiMap.toString());
        System.out.println(m.cache.toString());
        
        System.out.println("------");
        m.delete("k3", "v5");
        m.delete("k2", "v5");
        System.out.println(m.multiMap.toString());
        System.out.println(m.cache.toString());
    }

}
