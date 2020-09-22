package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.RouteRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.RouteService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

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
        Route routeFromRepo = routeRepository.findById(route.getId()).get();
        routeFromRepo.setOriginPlanetNode(route.getOriginPlanetNode());
        routeFromRepo.setDestinationPlanetNode(route.getDestinationPlanetNode());
        routeFromRepo.setDistance(route.getDistance());
        routeRepository.save(routeFromRepo);
    }

    @Override
    public void delete(Route route) {
        routeRepository.delete(route);
    }

    @Override
    public void saveAll(List<Route> routes) {
        routeRepository.saveAll(routes);
    }
}
