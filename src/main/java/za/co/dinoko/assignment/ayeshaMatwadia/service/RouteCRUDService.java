package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;

import java.util.List;

public interface RouteCRUDService {
    void create(int routeId, String planetOrigin, String planetDestination, double distanceLightYears);
    List<Route> read();
    void update(int routeId, String planetOrigin, String planetDestination, double distanceLightYears);
    void delete(int routeId);
}
