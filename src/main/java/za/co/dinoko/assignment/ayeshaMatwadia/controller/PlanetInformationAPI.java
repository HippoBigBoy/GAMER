package za.co.dinoko.assignment.ayeshaMatwadia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;
import java.util.List;

@RestController
@RequestMapping(value = "/planet")
public class PlanetInformationAPI {

    private PlanetService planetService;

    @Autowired
    public PlanetInformationAPI(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Planet planet) {
        planetService.create(planet);
    }

    @GetMapping(value = "/read")
    public List<Planet> read(){
        return planetService.read();
    }

    @PutMapping(value ="/update")
    public void update(@RequestBody Planet planet) {
        planetService.update(planet);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestBody Planet planet) {
        planetService.delete(planet);
    }

}
