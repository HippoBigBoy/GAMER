package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<>();
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }
}
