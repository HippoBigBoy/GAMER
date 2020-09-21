package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteCRUDService;

import java.util.List;
import java.util.Map;

@RestController
public class RouteInformationController {

    @Autowired
    RouteCRUDService routeCRUDService;

    @PostMapping(value = "/route/create")
    public void create(@RequestBody Map<String, String> payload) {
        int routeId = Integer.parseInt(payload.get("routeId"));
        String planetOrigin = payload.get("planetOrigin");
        String planetDestination = payload.get("planetDestination");
        double distance = Double.parseDouble(payload.get("distance"));
        routeCRUDService.create(routeId, planetOrigin, planetDestination, distance);
    }

    @GetMapping(value = "/route/read")
    public List<Route> read(){
        return routeCRUDService.read();
    }

    @PutMapping(value = "/route/update")
    public void update(@RequestBody Map<String, String> payload) {
        int routeId = Integer.parseInt(payload.get("routeId"));
        String planetOrigin = payload.get("planetOrigin");
        String planetDestination = payload.get("planetDestination");
        double distance = Double.parseDouble(payload.get("distance"));
        routeCRUDService.update(routeId, planetOrigin, planetDestination, distance);
    }

    @DeleteMapping(value = "/route/delete")
    public void delete(@RequestBody Map<String, String> payload) {
        int routeId = Integer.parseInt(payload.get("routeId"));
        routeCRUDService.delete(routeId);
    }
}