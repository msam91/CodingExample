package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphTransitiveClosure {
    int totalVertex;
    LinkedList<AdjListNode> adjList[];
    int[][] tc;

    public GraphTransitiveClosure(int V) {
        this.totalVertex = V;
        adjList = new LinkedList[V];
        tc = new int[V][V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<AdjListNode>();
        }
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                tc[i][j] = 0;
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

    }

    public void addEdge(int src, int dest, int weight) {
        // directed
        AdjListNode edge = new AdjListNode(dest, weight);
        adjList[src].add(edge);

        // undirected graph
        // adjList[dest].addFirst(src);

    }

    public void printGraph(GraphTransitiveClosure graph)
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

    public void transitiveClousre(GraphTransitiveClosure graph) {

        for (int i = 0; i < graph.totalVertex; i++) {
            DFSUtils(i, i, graph);
        }
        for (int i = 0; i < graph.totalVertex; i++)
        {
            for (int j = 0; j < graph.totalVertex; j++) {
                System.out.print(graph.tc[i][j] + "-");
            }
            System.out.println();
        }

    }

    private void DFSUtils(int src, int dest, GraphTransitiveClosure graph) {
        // TODO Auto-generated method stub
        graph.tc[src][dest] = 1;

        Iterator<AdjListNode> itr = graph.adjList[dest].listIterator();
        while (itr.hasNext()) {
            AdjListNode v = itr.next();
            if (graph.tc[src][v.dest] == 0) {
                DFSUtils(src, v.dest, graph);
            }
        }

    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        GraphTransitiveClosure g = new GraphTransitiveClosure(4);
        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(2, 0, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 3, 0);

        g.transitiveClousre(g);
    }
}
