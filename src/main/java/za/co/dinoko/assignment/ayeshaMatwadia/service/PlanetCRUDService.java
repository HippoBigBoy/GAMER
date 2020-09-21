package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;

import java.util.List;

public interface PlanetCRUDService {

    void create(String planetNode, String planetName);
    List<Planet> read();
    void update(String planetNode, String planetName);
    void delete(String planetNode);
}
