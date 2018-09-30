package GraphAlgo;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;

import GraphAlgo.Graph.Edge;
import GraphAlgo.Graph.Vertex;
import Trees.BinaryMinHeap;

public class DijkstraShortestPath {

    public static void main(String args[]){
        Graph graph = new Graph(false);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);
        
        Vertex sourceVertex = graph.getVertex(1);
         DijkstraShortestPath dsp = new DijkstraShortestPath();
         dsp.shortestPath(sourceVertex, graph);

    }

    private Map<Vertex,Integer> shortestPath(Vertex sourceVertex,Graph graph ) {
        BinaryMinHeap<Vertex>minHeap = new BinaryMinHeap<Graph.Vertex>();
        Map<Vertex,Integer>distance = new HashMap<Vertex, Integer>();
        Map<Vertex,Vertex> parent = new HashMap<Graph.Vertex, Graph.Vertex>();
        
        for(Vertex v : graph.getAllVertex()){
            minHeap.add(Integer.MAX_VALUE, v);
        }
        
        minHeap.decrease(sourceVertex, 0);
        distance.put(sourceVertex, 0);
        parent.put(sourceVertex, null);
        
        while(!minHeap.empty()){
           BinaryMinHeap<Vertex>.Node heapNode = minHeap.extractMinNode();  
           
           Vertex current = heapNode.key;
           int dist = heapNode.weight;          
           distance.put(current, dist);           
           for(Edge edge : current.getEdges()){               
               Vertex adjacent = getVertexForEdge(current, edge);
               //if heap does not contain adjacent vertex means adjacent vertex already has shortest distance from source vertex
               if(!minHeap.containsData(adjacent)){
                   continue;
               }
               //add distance of current vertex to edge weight to get distance of adjacent vertex from source vertex
               //when it goes through current vertex
               int newDistance = distance.get(current) + edge.getWeight();

               //see if this above calculated distance is less than current distance stored for adjacent vertex from source vertex
               if(minHeap.getWeight(adjacent) > newDistance) {
                   minHeap.decrease(adjacent, newDistance);
                   parent.put(adjacent, current);
               }
           }
          
            
        }
       return distance; 
    }
    
    private Vertex getVertexForEdge(Vertex v, Edge e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }
}
