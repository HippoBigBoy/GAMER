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

import java.io.File;
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
        String fileName = "SupportData-V1.xlsx";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        List<Planet> planets = readFileService.readPlanetsFromFile(file);
        List<Route> routes = readFileService.readRoutesFromFile(file);
        planetRepository.saveAll(planets);
        routeRepository.saveAll(routes);
    }
}
