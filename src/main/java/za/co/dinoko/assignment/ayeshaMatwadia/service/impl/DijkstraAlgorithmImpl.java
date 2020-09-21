package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.DijkstraAlgorithm;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.VertexEdgeService;

import java.util.*;

@Service
public class DijkstraAlgorithmImpl implements DijkstraAlgorithm {

    @Autowired
    PlanetService planetService;

    @Autowired
    RouteService routeService;

    @Autowired
    VertexEdgeService vertexEdgeService;

    private void computePath(Vertex sourceVertex) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();

            for (Edge edge : vertex.getEdges()) {
                Vertex v = edge.getTargetVertex();
                double weight = edge.getWeight();
                double minDistance = vertex.getMinDistance() + weight;

                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(vertex);
                    v.setPreviousVertex(vertex);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
                }
            }
        }
    }

    @Override
    public List<Vertex> getShortestPath(String startVertex, String targetVertex) {
        Map<String, Vertex> vertexMap = vertexEdgeService.getVertexWithEdgeMap(planetService.read(), routeService.read());
        Vertex originVertex = vertexMap.get(startVertex);
        Vertex target = vertexMap.get(targetVertex);
        computePath(originVertex);

        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = target; vertex != null; vertex = vertex.getPreviousVertex()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
}
