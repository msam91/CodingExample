package GraphAlgo;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    List<Edge> allEdges;
    Map<Long, Vertex> allVertex;
    boolean isDirected;

    public Graph( boolean isDirected) {
        allEdges = new ArrayList<Edge>();
        allVertex = new HashMap<Long, Vertex>();
        this.isDirected = isDirected;

    }
    public void addEdge(long id1, long id2) {
        addEdge(id1, id2,0);
    }
    
    public void addEdge(long id1, long id2, int weight) {
        Vertex v1 = null;
        Vertex v2 = null;
        if (allVertex.containsKey(id1)) {
            v1 = allVertex.get(id1);
        }
        else {
            v1 = new Vertex(id1);
            allVertex.put(id1, v1);
        }
        if (allVertex.containsKey(id2)) {
            v2 = allVertex.get(id2);
        }
        else {
            v2 = new Vertex(id2);
            allVertex.put(id2, v2);
        }
        Edge e = new Edge(v1, v2, isDirected);
        allEdges.add(e);

        v1.addAdjacentVertex(e, v2);
        if (!isDirected) {
            v2.addAdjacentVertex(e, v1);
        }
    }
    
    public List<Edge> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex> getAllVertex(){
        return allVertex.values();
    }
    
    public Vertex getVertex(long id) {
        return allVertex.get(id);
    }
    

    public class Vertex {
        private Long id;
        private int data;
        private List<Vertex> adjVertex = new ArrayList<Vertex>();
        private List<Edge> edgesFromVertex = new ArrayList<Edge>();

        Vertex(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public int getData() {
            return data;
        }

        public List<Edge> getEdges() {
            return edgesFromVertex;
        }

        public List<Vertex> getAdjacentVertex() {
            return adjVertex;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void addAdjacentVertex(Edge e, Vertex v) {
            edgesFromVertex.add(e);
            adjVertex.add(v);
        }

        @Override
        public String toString() {
            return "Vertex [id=" + id + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            }
            else if (!id.equals(other.id))
                return false;
            return true;
        }

        private Graph getOuterType() {
            return Graph.this;
        }
        
        

    }

    public class Edge {
        private Vertex v1;
        private Vertex v2;
        private int weight;
        private boolean isDirected = false;

        Edge(Vertex v1, Vertex v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        Edge(Vertex v1, Vertex v2, boolean isDirected, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        Edge(Vertex v1, Vertex v2, boolean isDirected) {
            this.v1 = v1;
            this.v2 = v2;
            this.isDirected = isDirected;
        }

        public Vertex getVertex1() {
            return v1;
        }

        public Vertex getVertex2() {
            return v2;
        }

        public int getWeight() {
            return weight;
        }

        public boolean isDirected() {
            return isDirected;
        }


        
    }

}
