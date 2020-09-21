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
    public void create(@RequestBody Planet planet) {
        planetService.create(planet);
    }

    @GetMapping(value = "/planet/read")
    public List<Planet> read(){
        return planetService.read();
    }

    @PutMapping(value ="/planet/update")
    public void update(@RequestBody Planet planet) {
        planetService.update(planet);
    }

    @DeleteMapping(value = "/planet/delete")
    public void delete(@RequestBody Planet planet) {
        planetService.delete(planet);
    }

}
