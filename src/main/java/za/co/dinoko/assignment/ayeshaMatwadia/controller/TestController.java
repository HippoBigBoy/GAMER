package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.DijkstraAlgorithm;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.TestService;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ReadFileService readFileService;

    @Autowired
    private DijkstraAlgorithm dijkstraAlgorithm;

    @GetMapping("/greeting")
    public String greeting() {

        return "Hello There";
    }

    @GetMapping("/dijkstra")
    public String doThis() {
        Map<String,Vertex> v = readFileService.readDataFromExcelFileAndCreateVertexMap();
        Vertex earth = v.get("A");
        Vertex farPlanet = v.get("K'");

        dijkstraAlgorithm.computePath(earth);

        List<Vertex> s = dijkstraAlgorithm.getShortestPath(farPlanet);

        return s.toString();
    }

    @GetMapping("/read")
    public String readFile() {
        Map<String,Vertex> v = readFileService.readDataFromExcelFileAndCreateVertexMap();

        for (Map.Entry<String, Vertex> entry : v.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        return "readingFile";
    }
}
