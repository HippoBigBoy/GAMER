package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;
import java.util.List;

@RestController
public class RouteInformationController {

    @Autowired
    RouteService routeService;

    @PostMapping(value = "/route/create")
    public void create(@RequestBody Route route) {
        routeService.create(route);
    }

    @GetMapping(value = "/route/read")
    public List<Route> read(){
        return routeService.read();
    }

    @PutMapping(value = "/route/update")
    public void update(@RequestBody Route route) {
        routeService.update(route);
    }

    @DeleteMapping(value = "/route/delete")
    public void delete(@RequestBody Route route) {
        routeService.delete(route);
    }
}
