package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import java.util.Objects;

public class Edge {
    private Vertex to;
    private int weight;

    public Edge(Vertex to, int weight) {
        super();
        this.to = to;
        this.weight = weight;
    }

    public Vertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
