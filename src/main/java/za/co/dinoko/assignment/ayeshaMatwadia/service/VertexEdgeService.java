package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;

import java.util.List;
import java.util.Map;

public interface VertexEdgeService {
    Map<String, Vertex> getVertexWithEdgeMap(List<Planet> planets, List<Route> routes);
}
