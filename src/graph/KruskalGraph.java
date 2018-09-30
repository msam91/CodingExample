package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class KruskalGraph {
    int totalVertex;
    List<Edge<String>>edges = new ArrayList<Edge<String>>();
    
    public KruskalGraph(int v){
        totalVertex = v;
    }
    

    // Creates a graph with V vertices and E edges

    public static void main(String[] args){
        int V = 6;
        KruskalGraph graph = new KruskalGraph(V);
        graph.edges.add(new Edge<String>("A","B",3));
        graph.edges.add(new Edge <String>("B","C",1));
        graph.edges.add(new Edge <String>("A","D",1));
        graph.edges.add(new Edge <String>("B", "D",3));
        graph.edges.add(new Edge<String>("D","C",1));
        graph.edges.add(new Edge <String>("D","E",6));
        graph.edges.add(new Edge <String>("C","E",5));
        graph.edges.add(new Edge <String>("E", "F",2));
        graph.edges.add(new Edge<String>("F","C",1));
        DisjointSet<String> ds = new DisjointSet<String>();
        ds.makeSet("A"); ds.makeSet("B"); ds.makeSet("C"); ds.makeSet("D");
        ds.makeSet("E");ds.makeSet("F");
        
        ArrayList<Edge<String>>result = new ArrayList<Edge<String>>();
        
        Collections.sort(graph.edges);
        
        for(Edge<String> edge : graph.edges){            
           if( ds.findSet(edge.src) != ds.findSet(edge.dest)){
               ds.union(edge.src, edge.dest);
               result.add(edge);
           }
           
        }
        
        for(Edge<String> edge : result){
            System.out.println("Edge minnimum spanning tree is"+edge.src+"-->"+edge.dest);
        }
        
    }
}

class Edge<T> implements Comparable<Edge<T>>
{
    T src;
    T dest;
    int weight;
    
    public Edge(T src,T dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight =weight;
    }
    @Override
    public int compareTo(Edge<T> o) {
        // TODO Auto-generated method stub
        return this.weight-o.weight;
    }
    
}
