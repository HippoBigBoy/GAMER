package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.VertexEdgeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class VertexEdgeServiceImpl implements VertexEdgeService {
    @Override
    public Map<String, Vertex> getVertexWithEdgeMap(List<Planet> planets, List<Route> routes) {
        Map<String, Vertex> vertexMap = new HashMap<>();
        for(Planet planet: planets) {
            vertexMap.put(planet.getNode(), new Vertex(planet.getNode(), planet.getName()));
        }
        for(Route route: routes) {
            if(!vertexMap.containsKey(route.getOriginPlanetNode())){
                vertexMap.put(route.getOriginPlanetNode(), new Vertex(route.getOriginPlanetNode(), UUID.randomUUID().toString()));
            }
            if(!vertexMap.containsKey(route.getDestinationPlanetNode())){
                vertexMap.put(route.getDestinationPlanetNode(), new Vertex(route.getDestinationPlanetNode(), UUID.randomUUID().toString()));
            }
            Vertex originVertex = vertexMap.get(route.getOriginPlanetNode());
            Vertex destinationVertex = vertexMap.get(route.getDestinationPlanetNode());
            originVertex.addNeighbour(new Edge(route.getDistance(), originVertex, destinationVertex));
            vertexMap.put(route.getOriginPlanetNode(),originVertex);
//          adding the reverse route
            destinationVertex.addNeighbour(new Edge(route.getDistance(), destinationVertex, originVertex));
            vertexMap.put(route.getDestinationPlanetNode(), destinationVertex);
        }
        return vertexMap;
    }
}
