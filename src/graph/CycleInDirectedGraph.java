package graph;

import graph.GraphAdjList.AdjListNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class CycleInDirectedGraph {
    int totalVertex;
    LinkedList<Integer> adjList[];

    public CycleInDirectedGraph(int V) {
        this.totalVertex = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

    }

    public void addEdge(int src, int dest) {
        // directed
        adjList[src].add(dest);

        // undirected graph
        // adjList[dest].addFirst(src);

    }

    public void printGraph(GraphAdjList graph)
    {
        for (int v = 0; v < graph.totalVertex; v++)
        {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (AdjListNode pCrawl : graph.adjList[v]) {
                System.out.print(" -> " + pCrawl.dest);
            }
            System.out.println("\n");
        }
    }

    public boolean isCycle(CycleInDirectedGraph graph) {
        Set<Integer> whiteSet = new HashSet<Integer>();
        Set<Integer> greySet = new HashSet<Integer>();
        Set<Integer> blackSet = new HashSet<Integer>();

        for (int i = 0; i < graph.totalVertex; i++) {
            whiteSet.add(i);
        }

        if (dfsUtils(0, whiteSet, greySet, blackSet, graph)) {
            return true;
        }
        return false;
    }

    public boolean dfsUtils(int current, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet, CycleInDirectedGraph graph) {
        moveVertex(current, whiteSet, greySet);
        Iterator<Integer> itr = graph.adjList[current].iterator();
        int neighbour = -1;
        while (itr.hasNext()) {
            neighbour = itr.next();
            if (blackSet.contains(neighbour)) {
                continue;
            }
            if (greySet.contains(neighbour)) {
                return true;
            }
            boolean checkCyclesforNeighbours=dfsUtils(neighbour, whiteSet, greySet, blackSet, graph);
            if (checkCyclesforNeighbours) {
                return true;
            }
        }
        if (neighbour != -1) {
            moveVertex(neighbour, whiteSet, blackSet);
        }
        return false;
    }

    public void moveVertex(int current, Set<Integer> sourceSet, Set<Integer> destSet) {
        sourceSet.remove(current);
        destSet.add(current);
    }

    public static void main(String args[]) {
        CycleInDirectedGraph g = new CycleInDirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        if (g.isCycle(g)) {
            System.out.println("Cycle Present");
        }
        else {
            System.out.println("Cycle Not Present");
        }

    }
}
