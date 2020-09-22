package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;
import java.util.List;

@RestController
@RequestMapping(value = "/route")
public class RouteInformationAPI {

    private RouteService routeService;

    @Autowired
    public RouteInformationAPI(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Route route) {
        routeService.create(route);
    }

    @GetMapping(value = "/read")
    public List<Route> read(){
        return routeService.read();
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Route route) {
        routeService.update(route);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestBody Route route) {
        routeService.delete(route);
    }
}
