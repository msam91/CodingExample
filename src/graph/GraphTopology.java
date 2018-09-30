package graph;



import java.util.LinkedList;
import java.util.Stack;

;

public class GraphTopology {

    public LinkedList<NeighbourNode> adjList[];
    public int v;

    public GraphTopology(int totalVertices) {
        this.v = totalVertices;
        adjList = new LinkedList[totalVertices];

        for (int i = 0; i < totalVertices; i++) {
            adjList[i] = new LinkedList<NeighbourNode>();
        }

    }

    class NeighbourNode {
        int dest;
        int weight;

        public NeighbourNode(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

    }
    
    public void addEdge(int src, int dest,int weight){
        NeighbourNode neighbourNode = new NeighbourNode(dest, weight);
        adjList[src].add(neighbourNode);
        
    }
    
    public static void main(String args[]){
        GraphTopology g = new GraphTopology(6);
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
        g.topologicalSort();
        
        Stack<Integer>st= g.topologicalSort();
        System.out.print("toplogical order is-->");
        while(!st.isEmpty()){
            System.out.print(st.pop()+"->");
        }
        
        
    }    
    public Stack<Integer> topologicalSort(){
        
        boolean visited[] = new boolean[v];
        Stack<Integer>stack = new Stack<Integer>();      
        for(int i=0;i<v;i++){
            
            if(!visited[i]){
                topologicalSortUtil(i,visited,stack);
            }
        }
        return stack;
    }

    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] =true;
        
        for(NeighbourNode neighbourNode :adjList[vertex]){
            
            int neighbour = neighbourNode.dest;
            if(!visited[neighbour]){
                topologicalSortUtil(neighbour,visited,stack);
            }  
        }
        
        stack.push(vertex);
        
    }
}
