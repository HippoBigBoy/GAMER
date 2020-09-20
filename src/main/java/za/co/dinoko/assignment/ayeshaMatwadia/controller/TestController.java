package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Graph;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.DijkstraAlgorithm;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.TestService;

import java.util.List;

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
//        Vertex v1 = new Vertex("A");
//        Vertex v2 = new Vertex("B");
//        Vertex v3 = new Vertex("C");
//
//        v1.addNeighbour(new Edge(1, v1, v2));
//        v1.addNeighbour(new Edge(10, v1, v2));
//
//        v2.addNeighbour(new Edge(1, v2, v3));
//
//        dijkstraAlgorithm.computePath(v1);
//
//        List<Vertex> s = dijkstraAlgorithm.getShortestPath(v3);
//        System.out.println(s);

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        a.addNeighbour(new Edge(1,a, b));
        b.addNeighbour(new Edge(1,b, c));
        c.addNeighbour(new Edge(1,c, d));
        d.addNeighbour(new Edge(1,d, e));
        e.addNeighbour(new Edge(1,e, f));
        a.addNeighbour(new Edge(10,a, f));

        dijkstraAlgorithm.computePath(a);

        List<Vertex> s = dijkstraAlgorithm.getShortestPath(f);

        return s.toString();
    }

    @GetMapping("/read")
    public String readFile() {
        readFileService.readDataFromExcelFile();
        return "readingFile";
    }
}
