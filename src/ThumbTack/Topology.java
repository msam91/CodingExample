package ThumbTack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Topology {

    static Stack<String> stack = new Stack<String>();

    public static void main(String args[]) {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        String[] a = { "b.jar", "c.jar" };
        map.put("a.jar", Arrays.asList(a));
        String[] b = { "d.jar", "e.jar"};
        map.put("b.jar", Arrays.asList(b));
        
        String[] c = { "e.jar", "f.jar"};
        map.put("c.jar", Arrays.asList(c));
        
        String[] d = {"f.jar" };
        map.put("d.jar", Arrays.asList(d));
        

        topoLogicalSort(map);
         while(!stack.isEmpty()){
             System.out.println(stack.pop());
         }
        

    }

    public static void topoLogicalSort(Map<String, List<String>> map) {

        Set<String> visited = new HashSet<String>();
        for (String s : map.keySet()) {
            if (!visited.contains(s)) {
                topologicalSortUtil(visited, map, s);
            }

        }

    }

    private static void topologicalSortUtil(Set<String> visited, Map<String, List<String>> map, String s) {
        visited.add(s);
        if (map.containsKey(s)) {
            for (String n : map.get(s)) {
                if (!visited.contains(n)) {
                    topologicalSortUtil(visited, map, n);
                }
            }
        }
        stack.push(s);

    }

}
