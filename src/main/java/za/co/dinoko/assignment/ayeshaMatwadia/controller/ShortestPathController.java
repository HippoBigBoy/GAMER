package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.DijkstraAlgorithm;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;

import java.util.List;
import java.util.Map;

@RestController
public class ShortestPathController {

    @Autowired
    private ReadFileService readFileService;

    @Autowired
    private DijkstraAlgorithm dijkstraAlgorithm;


    @PostMapping(value = "/shortestPath")
    public String doThis(@RequestBody Map<String, String> payload) {
        boolean payLoadValuesAreNull = payload.get("startPlanet") == null || payload.get("destinationPlanet") == null;
        if(!payLoadValuesAreNull){
           Map<String,Vertex> v = readFileService.readDataFromExcelFileAndCreateVertexMap();
           Vertex earth = v.get(payload.get("startPlanet").toUpperCase());
           Vertex farPlanet = v.get(payload.get("destinationPlanet").toUpperCase());
           dijkstraAlgorithm.computePath(earth);
           List<Vertex> s = dijkstraAlgorithm.getShortestPath(farPlanet);
           return s.toString();
       } else {
           return "{'error': 'Sorry you need to provide a startPlanet and a " +
                   "destinationPlanet in the JSON you send to this endpoint'}";
       }
    }
}
