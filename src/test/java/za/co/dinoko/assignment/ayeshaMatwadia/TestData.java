package za.co.dinoko.assignment.ayeshaMatwadia;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {

    public static List<Planet> PlanetData1() {
        List<Planet> expectedPlanets = new ArrayList<>();
        expectedPlanets.add(new Planet("A", "Earth"));
        expectedPlanets.add(new Planet("B"   , "Moon"));
        expectedPlanets.add(new Planet("C", "Jupiter"));
        expectedPlanets.add(new Planet("D", "Venus"));
        expectedPlanets.add(new Planet("E", "Mars"));
        return expectedPlanets;
    }

    public static List<Route> routeData1(){
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(1, "A", "B", 0.44));
        routes.add(new Route(2, "A", "C", 1.89));
        routes.add(new Route(3, "A", "D", 0.10));
        routes.add(new Route(4, "B", "H", 2.44));
        routes.add(new Route(5, "B", "E", 3.45));
        routes.add(new Route(6, "C", "F", 0.49));
        routes.add(new Route(7, "D", "L", 2.34));
        routes.add(new Route(8, "D", "M", 2.61));
        routes.add(new Route(10, "E", "I", 8.09));
        return routes;
    }

    public static Map<String, Vertex> mockVertexEdgeMap() {
        Map<String, Vertex> vertexMap = new HashMap<>();

        Vertex a = new Vertex("A", "Aaa");
        Vertex b = new Vertex("B", "Bbb");
        Vertex c = new Vertex("C", "Ccc");
        Vertex d = new Vertex("D", "Ddd");
        Vertex e = new Vertex("E", "Eee");
        Vertex f = new Vertex("F", "Fff");
        Vertex g = new Vertex("G", "Ggg");
        Vertex h = new Vertex("H", "Hhh");

        a.addNeighbour(new Edge(1, a, b));
        b.addNeighbour(new Edge(2, b, c));
        b.addNeighbour(new Edge(2, b, e));
        c.addNeighbour(new Edge(3, c, d));
        d.addNeighbour(new Edge(4, d, g));
        g.addNeighbour(new Edge(5, g, h));
        e.addNeighbour(new Edge(4, e, f));
        f.addNeighbour(new Edge(3, f, h));

        vertexMap.put("A", a);
        vertexMap.put("B", b);
        vertexMap.put("C", c);
        vertexMap.put("D", d);
        vertexMap.put("E", e);
        vertexMap.put("F", f);
        vertexMap.put("G", g);
        vertexMap.put("H", h);
        return vertexMap;
    }

    public static List<Vertex> expectedHops() {
        List<Vertex> expected = new ArrayList<>();
        expected.add(new Vertex("A", "Aaa"));
        expected.add(new Vertex("B", "Bbb"));
        expected.add(new Vertex("E", "Eee"));
        expected.add(new Vertex("F", "Fff"));
        expected.add(new Vertex("H", "Hhh"));
        return expected;
    }
}
