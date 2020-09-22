package za.co.dinoko.assignment.ayeshaMatwadia.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.dinoko.assignment.ayeshaMatwadia.TestData;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.impl.ShortestPathServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<Vertex> expected = TestData.expectedHops();
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
        when(vertexEdgeServiceMock.getVertexWithEdgeMap(any(),any())).thenReturn(TestData.mockVertexEdgeMap());
        return new ShortestPathServiceImpl(
                planetServiceMock, routeServiceMock, vertexEdgeServiceMock);
    }
}
