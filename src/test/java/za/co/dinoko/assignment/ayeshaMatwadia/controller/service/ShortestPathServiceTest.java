package za.co.dinoko.assignment.ayeshaMatwadia.controller.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.VertexEdgeService;
import za.co.dinoko.assignment.ayeshaMatwadia.service.impl.ShortestPathServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShortestPathServiceTest {

@Test
public void passingEmptyPlanetsAndRoutesToTheShortestPathAlgorithmThrowsANullPointerException(){
    ShortestPathServiceImpl shortestPathService = getShortestPathServiceMockedOutOtherServicesNoData();
    assertThrows(NullPointerException.class,
            () -> shortestPathService.getShortestPath("A", "B"));
}

    @Test
    public void shortestPathReturnsTheCorrectStepsForAGivenVertexMap(){
        ShortestPathServiceImpl shortestPathService = getShortestPathServiceMockedOutOtherServicesData();
        List<Vertex> vertices = shortestPathService.getShortestPath("A", "H");
        List<Vertex> expected = expectedHops();
        assertFalse(vertices.isEmpty());
        assert (vertices.get(0).getPlanetNode() == expected.get(0).getPlanetNode());
        assert (vertices.get(1).getPlanetNode() == expected.get(1).getPlanetNode());
        assert (vertices.get(2).getPlanetNode() == expected.get(2).getPlanetNode());
        assert (vertices.get(3).getPlanetNode() == expected.get(3).getPlanetNode());
        assert (vertices.get(4).getPlanetNode() == expected.get(4).getPlanetNode());
        assert (vertices.size() == 5);
    }

    private ShortestPathServiceImpl getShortestPathServiceMockedOutOtherServicesNoData() {
        PlanetService planetServiceMock = mock(PlanetService.class);
        when(planetServiceMock.read()).thenReturn(new ArrayList<>());
        RouteService routeServiceMock = mock(RouteService.class);
        when(routeServiceMock.read()).thenReturn(new ArrayList<>());
        VertexEdgeService vertexEdgeServiceMock = mock(VertexEdgeService.class);
        when(vertexEdgeServiceMock.getVertexWithEdgeMap(any(),any())).thenReturn(new HashMap<>());
        return new ShortestPathServiceImpl(
                planetServiceMock, routeServiceMock, vertexEdgeServiceMock);
    }

    private ShortestPathServiceImpl getShortestPathServiceMockedOutOtherServicesData() {
        PlanetService planetServiceMock = mock(PlanetService.class);
        when(planetServiceMock.read()).thenReturn(new ArrayList<>());
        RouteService routeServiceMock = mock(RouteService.class);
        when(routeServiceMock.read()).thenReturn(new ArrayList<>());
        VertexEdgeService vertexEdgeServiceMock = mock(VertexEdgeService.class);
        when(vertexEdgeServiceMock.getVertexWithEdgeMap(any(),any())).thenReturn(buildValidVertexMapWithMockedData());
        return new ShortestPathServiceImpl(
                planetServiceMock, routeServiceMock, vertexEdgeServiceMock);
    }


    private Map<String, Vertex> buildValidVertexMapWithMockedData(){
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

    private List<Vertex> expectedHops() {
        List<Vertex> expected = new ArrayList<>();
        expected.add(new Vertex("A", "Aaa"));
        expected.add(new Vertex("B", "Bbb"));
        expected.add(new Vertex("E", "Eee"));
        expected.add(new Vertex("F", "Fff"));
        expected.add(new Vertex("H", "Hhh"));
        return expected;
    }
}
