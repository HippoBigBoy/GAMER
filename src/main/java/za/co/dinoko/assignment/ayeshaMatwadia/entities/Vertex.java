package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import java.util.*;

public class Vertex implements Comparable<Vertex> {
    private String label;
    private List<Edge> edges;
    private boolean visited;
    private Vertex previousVertex;
    private double minDistance = Double.MAX_VALUE;

    public Vertex(String label) {
        this.label = label;
        this.edges = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.minDistance, otherVertex.minDistance);
    }
}
