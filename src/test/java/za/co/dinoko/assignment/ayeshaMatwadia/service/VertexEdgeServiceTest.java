package za.co.dinoko.assignment.ayeshaMatwadia.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.dinoko.assignment.ayeshaMatwadia.TestData;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.impl.VertexEdgeServiceImpl;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VertexEdgeServiceTest {

    VertexEdgeServiceImpl vertexEdgeService = new VertexEdgeServiceImpl();

    @Test
    public void passingInEmptyPlanetsAndRoutesReturnsAnEmptyMap(){
      Map<String, Vertex> vertexMap = vertexEdgeService.getVertexWithEdgeMap(new ArrayList<>(), new ArrayList<>());
      assertTrue(vertexMap.isEmpty());
    }

    @Test
    public void givenPlanetsAndRouteTheVertexEdgeServiceWillCreateTheCorrectGraphStructure(){
        Map<String, Vertex> vertexMap = vertexEdgeService.getVertexWithEdgeMap(TestData.PlanetData1(), TestData.routeData1());
        assertFalse(vertexMap.isEmpty());
        String[] expectedKeys = new String[] {"A", "B", "C", "D", "E", "H", "F", "L", "M", "I"};
        for(String s : expectedKeys){
            assert(vertexMap.containsKey(s));
        }
    }
}
