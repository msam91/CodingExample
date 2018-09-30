package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjList {
    int totalVertex;
    LinkedList<AdjListNode> adjList[];

    public GraphAdjList(int numberOfVertices) {
        this.totalVertex = numberOfVertices;
        adjList = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adjList[i] = new LinkedList<AdjListNode>();
        }

    }

    class AdjListNode {
        int dest;
        int weight;

        public AdjListNode(int v, int weight) {
            this.dest = v;
            this.weight = weight;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int v) {
            this.dest = v;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "AdjListNode [dest=" + dest + ", weight=" + weight + "]";
        }

    }

    public void addEdge(int src, int dest, int weight) {
        // directed
        AdjListNode edge = new AdjListNode(dest, weight);
        adjList[src].add(edge);

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

    public void printGraph(LinkedList<AdjListNode>[] adjList, int totalVertex)
    {
        for (int v = 0; v < totalVertex; v++)
        {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (AdjListNode pCrawl : adjList[v]) {
                System.out.print(" -> " + pCrawl.dest);
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 6;
        GraphAdjList g = new GraphAdjList(V);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        // print the adjacency list representation of
        // the above graph
        g.printLongestDistancePath(g, 1);
        System.out.println();
        g.dfs(1);
        System.out.println();
        g.printGraph(g);
        System.out.println();
        System.out.println("---reverse--");
        LinkedList<AdjListNode>[] newAdjList = g.reverseGraph(g);
        g.printGraph(newAdjList, g.totalVertex);

    }

    public void printLongestDistancePath(GraphAdjList graph, int src) {
        Deque<Integer> stack = graph.topologicalSort(src);
        int distance[] = new int[graph.totalVertex];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MIN_VALUE;
        }
        distance[src] = 0;

        while (!stack.isEmpty()) {
            int u = stack.poll();         
            if (distance[u] != Integer.MIN_VALUE) {               
                for(AdjListNode neighbour :adjList[u]){
                    if (distance[neighbour.dest] < distance[u] +neighbour.weight) {
                        distance[neighbour.dest] = distance[u] + neighbour.weight;
                    }

                }
            }

        }
        for (int i = 0; i < graph.totalVertex; i++) {
            if (distance[i] == Integer.MIN_VALUE)
                System.out.print("INF");
            else
                System.out.print(distance[i] + " ");
        }
    }

    public void dfsUtil(boolean visited[], int v) {
        visited[v] = true;
        System.out.print(v + "-->");
       for(AdjListNode neighbour : adjList[v]) {
            int n = neighbour.dest;
            if (!visited[n]) {
                dfsUtil(visited, n);
            }
        }

    }

    public void topologicalSortUtil(boolean visited[], int v, Deque<Integer> stack) {
        visited[v] = true;    
        for(AdjListNode neighbour:adjList[v]){
            int n = neighbour.dest;
            if (!visited[n]) {
                topologicalSortUtil(visited, n, stack);
            }
        }
        stack.offerFirst(v);
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[totalVertex];
        dfsUtil(visited, v);
    }

    public Deque<Integer> topologicalSort(int v) {
        boolean visited[] = new boolean[totalVertex];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < totalVertex; i++) {
            if (!visited[i]) {
                topologicalSortUtil(visited, i, stack);
            }
        }
        return stack;
    }

    public LinkedList<AdjListNode>[] reverseGraph(GraphAdjList graph) {
        LinkedList<AdjListNode> newAdjList[] = new LinkedList[graph.totalVertex];
        for (int i = 0; i < graph.totalVertex; i++) {
            newAdjList[i] = new LinkedList<AdjListNode>();
        }
        for (int i = 0; i < graph.totalVertex; i++) {
            Iterator<AdjListNode> iter = adjList[i].listIterator();
            while (iter.hasNext()) {
                AdjListNode n = iter.next();
                newAdjList[n.dest].addFirst(new AdjListNode(i, n.weight));
            }
        }
        return newAdjList;
    }

}
