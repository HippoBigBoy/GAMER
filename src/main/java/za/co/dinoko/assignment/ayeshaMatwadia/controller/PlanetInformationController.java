package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;

import java.util.List;
import java.util.Map;

@RestController
public class PlanetInformationController {

    @Autowired
    PlanetService planetService;

    @PostMapping(value = "/planet/create")
    public void create(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        String planetName = payload.get("planetName");
        planetService.create(planetNode, planetName);
    }

    @GetMapping(value = "/planet/read")
    public List<Planet> read(){
        return planetService.read();
    }

    @PutMapping(value ="/planet/update")
    public void update(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        String planetName = payload.get("planetName");
        planetService.update(planetNode, planetName);
    }

    @DeleteMapping(value = "/planet/delete")
    public void delete(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        planetService.delete(planetNode);
    }

}
