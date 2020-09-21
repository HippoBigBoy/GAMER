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
            vertexMap.put(planet.getPlanetNode(), new Vertex(planet.getPlanetNode(), planet.getPlanetName()));
        }
        for(Route route: routes) {
            if(!vertexMap.containsKey(route.getPlanetOrigin())){
                vertexMap.put(route.getPlanetOrigin(), new Vertex(route.getPlanetOrigin(), UUID.randomUUID().toString()));
            }
            if(!vertexMap.containsKey(route.getPlanetDestination())){
                vertexMap.put(route.getPlanetDestination(), new Vertex(route.getPlanetDestination(), UUID.randomUUID().toString()));
            }
            Vertex originVertex = vertexMap.get(route.getPlanetOrigin());
            Vertex destinationVertex = vertexMap.get(route.getPlanetDestination());
            originVertex.addNeighbour(new Edge(route.getDistanceLightYears(), originVertex, destinationVertex));
            vertexMap.put(route.getPlanetOrigin(),originVertex);
//          adding the reverse route
            destinationVertex.addNeighbour(new Edge(route.getDistanceLightYears(), destinationVertex, originVertex));
            vertexMap.put(route.getPlanetDestination(), destinationVertex);
        }
        return vertexMap;
    }
}
