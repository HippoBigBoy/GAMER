package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.RouteRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteCRUDService;

import java.util.List;

@Service
public class RouteCRUDServiceImpl implements RouteCRUDService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public void create(int routeId, String planetOrigin, String planetDestination, double distanceLightYears) {
        routeRepository.save(new Route(routeId, planetOrigin, planetDestination, distanceLightYears));
    }

    @Override
    public List<Route> read() {
        return routeRepository.findAll();
    }

    @Override
    public void update(int routeId, String planetOrigin, String planetDestination, double distanceLightYears) {

//      todo handle the below Option
        Route routeFromRepo = routeRepository.findById(routeId).get();
        routeFromRepo.setRouteId(routeId);
        routeFromRepo.setPlanetOrigin(planetOrigin);
        routeFromRepo.setPlanetDestination(planetDestination);
        routeFromRepo.setDistanceLightYears(distanceLightYears);
        routeRepository.save(routeFromRepo);
    }

    @Override
    public void delete(int routeId) {
        routeRepository.deleteById(routeId);
    }
}
