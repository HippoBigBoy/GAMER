package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;

import java.util.List;

public interface PlanetService {

    void create(Planet planet);
    List<Planet> read();
    void update(Planet planet);

    void delete(Planet planet);
}
