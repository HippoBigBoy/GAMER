package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertex {

    String label;
    private Set<Edge> edges;

    public Vertex(String label) {
        this.label = label;
        this.edges = new HashSet<>();
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public String getLabel() {
        return label;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
}
