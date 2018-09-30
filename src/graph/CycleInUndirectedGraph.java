package graph;

public class CycleInUndirectedGraph {
    int totalVertex, totalEdge; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges

    class Edge
    {
        int src, dest;
    };

    // Creates a graph with V vertices and E edges
    CycleInUndirectedGraph(int v, int e)
    {
        totalVertex = v;
        totalEdge = e;
        edge = new Edge[totalEdge];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public boolean findCycle(CycleInUndirectedGraph g){
        DisjointSet<Integer> ds = new DisjointSet<Integer>();
        for(int i =0;i<g.totalVertex;i++){
            ds.makeSet(i);
        }       

        for(int i=0;i<g.totalEdge;i++){
           if( ds.findSet(g.edge[i].src) == ds.findSet(g.edge[i].dest)){
               return true;
           }
          ds.union(g.edge[i].src, g.edge[i].dest);  
        }
        return false;
    }

    public static void main(String[] args)
    {
        /*
         * Let us create following graph 0 | \ | \ 1-----2
         */
        int V = 3, E = 2;
        CycleInUndirectedGraph graph = new CycleInUndirectedGraph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
  
        
        if (graph.findCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
