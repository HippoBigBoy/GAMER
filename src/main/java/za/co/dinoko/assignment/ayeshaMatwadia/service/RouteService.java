package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;

import java.util.List;

public interface RouteService {
    void create(Route route);
    List<Route> read();
    void update(Route route);
    void delete(Route route);
}
