package za.co.dinoko.assignment.ayeshaMatwadia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.PlanetRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.RouteRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;

import java.util.List;

@Component
@Order(1)
public class StartupApplicationRunner implements ApplicationRunner {

    @Autowired
    ReadFileService readFileService;
    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    RouteRepository routeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Planet> planets = readFileService.readPlanetsFromFile();
        List<Route> routes = readFileService.readRoutesFromFile();
        System.out.println("There are how many planets " + planets.size());
        System.out.println("There are how many routes " + routes.size());
        planetRepository.saveAll(planets);
        routeRepository.saveAll(routes);
    }
}
