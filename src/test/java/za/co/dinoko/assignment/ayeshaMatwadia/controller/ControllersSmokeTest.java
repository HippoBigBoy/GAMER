package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllersSmokeTest {
    @Autowired
    PlanetInformationAPI planetInformationAPI;

    @Autowired
    RouteInformationAPI routeInformationAPI;

    @Autowired
    ShortestPathAPI shortestPathAPI;

    @Test
    public void planetInformationControllerContextLoads() {
        assertThat(planetInformationAPI).isNotNull();
    }

    @Test
    public void routeInformationControllerContextLoads() {
        assertThat(routeInformationAPI).isNotNull();
    }

    @Test
    public void shortestPathControllerContextLoads() {
        assertThat(shortestPathAPI).isNotNull();
    }

}
