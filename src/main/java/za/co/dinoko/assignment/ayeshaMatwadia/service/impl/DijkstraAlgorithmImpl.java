package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class DijkstraAlgorithmImpl implements DijkstraAlgorithm {

    @Override
    public void computePath(Vertex sourceVertex) {
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
    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
}
