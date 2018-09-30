package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph(boolean isDirected) {
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }
    

    public void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1 = null;
        if (allVertex.containsKey(id1)) {
            vertex1 = allVertex.get(id1);
        }
        else {
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if (allVertex.containsKey(id2)) {
            vertex2 = allVertex.get(id2);
        }
        else {
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if (!isDirected) {
            vertex2.addAdjacentVertex(edge, vertex1);
        }
    }

    // This works only for directed graph because for undirected graph we can
    // end up
    // adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex) {
        if (allVertex.containsKey(vertex.getId())) {
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for (Edge<T> edge : vertex.getEdges()) {
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(long id) {
        if (allVertex.containsKey(id)) {
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }

    public void setDataForVertex(long id, T data) {
        if (allVertex.containsKey(id)) {
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    public Vertex<T> getVertex(long id) {
        return allVertex.get(id);
    }

    public class Vertex<T> {
        private long id;
        private T data;
        private List<Edge<T>> edges = new ArrayList<>();
        private List<Vertex<T>> adjacentVertex = new ArrayList<>();

        Vertex(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public List<Vertex<T>> getAdjacentVertex() {
            return adjacentVertex;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
            edges.add(e);
            adjacentVertex.add(v);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((adjacentVertex == null) ? 0 : adjacentVertex.hashCode());
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            result = prime * result + ((edges == null) ? 0 : edges.hashCode());
            result = prime * result + (int) (id ^ (id >>> 32));
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
            if (adjacentVertex == null) {
                if (other.adjacentVertex != null)
                    return false;
            }
            else if (!adjacentVertex.equals(other.adjacentVertex))
                return false;
            if (data == null) {
                if (other.data != null)
                    return false;
            }
            else if (!data.equals(other.data))
                return false;
            if (edges == null) {
                if (other.edges != null)
                    return false;
            }
            else if (!edges.equals(other.edges))
                return false;
            if (id != other.id)
                return false;
            return true;
        }

        private Graph getOuterType() {
            return Graph.this;
        }

    }

    public class Edge<T> {
        private Vertex vertex1;
        private Vertex vertex2;
        private int weight;
        private boolean isDirected = false;

        Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = isDirected;
        }

        public Vertex getVertex1() {
            return vertex1;
        }

        public Vertex getVertex2() {
            return vertex2;
        }

        public int getWeight() {
            return weight;
        }

        public boolean isDirected() {
            return isDirected;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + (isDirected ? 1231 : 1237);
            result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
            result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
            result = prime * result + weight;
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
            Edge other = (Edge) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (isDirected != other.isDirected)
                return false;
            if (vertex1 == null) {
                if (other.vertex1 != null)
                    return false;
            }
            else if (!vertex1.equals(other.vertex1))
                return false;
            if (vertex2 == null) {
                if (other.vertex2 != null)
                    return false;
            }
            else if (!vertex2.equals(other.vertex2))
                return false;
            if (weight != other.weight)
                return false;
            return true;
        }

        private Graph getOuterType() {
            return Graph.this;
        }

    }
}
