package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;

import java.util.List;

public interface ShortestPathService {
    List<Vertex> getShortestPath(String startVertex,String targetVertex);
}
