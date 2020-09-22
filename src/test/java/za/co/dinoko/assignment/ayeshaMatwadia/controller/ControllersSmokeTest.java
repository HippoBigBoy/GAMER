package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllersSmokeTest {
    @Autowired
    PlanetInformationController planetInformationController;

    @Autowired
    RouteInformationController routeInformationController;

    @Autowired
    ShortestPathController shortestPathController;

    @Test
    public void planetInformationControllerContextLoads() {
        assertThat(planetInformationController).isNotNull();
    }

    @Test
    public void routeInformationControllerContextLoads() {
        assertThat(routeInformationController).isNotNull();
    }

    @Test
    public void shortestPathControllerContextLoads() {
        assertThat(shortestPathController).isNotNull();
    }

}
