package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.RouteRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public void create(Route route) {
        routeRepository.save(route);
    }

    @Override
    public List<Route> read() {
        return routeRepository.findAll();
    }

    @Override
    public void update(Route route) {
//      todo handle the below Option
        Route routeFromRepo = routeRepository.findById(route.getRouteId()).get();
        routeFromRepo.setPlanetOrigin(route.getPlanetOrigin());
        routeFromRepo.setPlanetDestination(route.getPlanetDestination());
        routeFromRepo.setDistanceLightYears(route.getDistanceLightYears());
        routeRepository.save(routeFromRepo);
    }

    @Override
    public void delete(Route route) {
        routeRepository.delete(route);
    }
}
