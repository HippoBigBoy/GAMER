package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetCRUDService;

import java.util.List;
import java.util.Map;

@RestController
public class PlanetInformationController {

    @Autowired
    PlanetCRUDService planetCRUDService;

    @PostMapping(value = "/planet/create")
    public void create(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        String planetName = payload.get("planetName");
        planetCRUDService.create(planetNode, planetName);
    }

    @GetMapping(value = "/planet/read")
    public List<Planet> read(){
        return planetCRUDService.read();
    }

    @PutMapping(value ="/planet/update")
    public void update(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        String planetName = payload.get("planetName");
        planetCRUDService.update(planetNode, planetName);
    }

    @DeleteMapping(value = "/planet/delete")
    public void delete(@RequestBody Map<String, String> payload) {
        String planetNode = payload.get("planetNode");
        planetCRUDService.delete(planetNode);
    }

}
