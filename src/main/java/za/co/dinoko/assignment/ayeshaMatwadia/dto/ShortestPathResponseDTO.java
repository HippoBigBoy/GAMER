package za.co.dinoko.assignment.ayeshaMatwadia.dto;

import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;

import java.util.List;

public class ShortestPathResponseDTO {
    private List<Vertex> shortestPath;
    private Long estimatedTimeToDestination;


    public ShortestPathResponseDTO(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Long getEstimatedTimeToDestination() {
        return estimatedTimeToDestination;
    }

    public void setEstimatedTimeToDestination(Long estimatedTimeToDestination) {
        this.estimatedTimeToDestination = estimatedTimeToDestination;
    }
}
