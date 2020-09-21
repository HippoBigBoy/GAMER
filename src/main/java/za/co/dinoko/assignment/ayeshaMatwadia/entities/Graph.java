package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import java.util.Map;

public class Graph {

    private Map<String, Vertex> verticesEdgeMap;

    public Graph(Map<String, Vertex> verticeEdgeMap) {
        this.verticesEdgeMap = verticeEdgeMap;
    }

    public Map<String, Vertex> getVerticesEdgeMap() {
        return verticesEdgeMap;
    }

    public void setVerticesEdgeMap(Map<String, Vertex> verticeEdgeMap) {
        this.verticesEdgeMap = verticeEdgeMap;
    }
}
