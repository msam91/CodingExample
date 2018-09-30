package GraphAlgo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import GraphAlgo.Graph.Vertex;

public class TopologicalSort {

    public static void main(String args[]) {

        Graph graph = new Graph(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        TopologicalSort ts = new TopologicalSort();
        Stack<Long> s = ts.topologicalSort(graph);
        while(!s.isEmpty()){
            System.out.print(s.pop()+"-->");
        }
    }

    private Stack<Long> topologicalSort(Graph graph) {
        Stack<Long> stack = new Stack<Long>();
        Set<Long> visited = new HashSet<Long>();

        for (Vertex v : graph.getAllVertex()) {

            if (visited.contains(v.getId())) {
                continue;
            }
            topologicalSortUtil(v, stack, visited);

        }
        return stack;
    }

    private void topologicalSortUtil(Vertex v, Stack<Long> stack, Set<Long> visited) {
        visited.add(v.getId());
        for (Vertex adjVertex : v.getAdjacentVertex()) {
            if(!visited.contains(adjVertex.getId())){
            topologicalSortUtil(adjVertex, stack, visited);
            }
        }
        stack.push(v.getId());

    }

}
