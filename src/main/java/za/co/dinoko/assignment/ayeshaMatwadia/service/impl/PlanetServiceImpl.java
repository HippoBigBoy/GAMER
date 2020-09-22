package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.PlanetRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    PlanetRepository planetRepository;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public void create(Planet planet) {
       planetRepository.save(planet);
    }

    @Override
    public List<Planet> read() {
        return planetRepository.findAll();
    }

    @Override
    public void update(Planet planet) {
//     Todo handle the option below better
       Planet planetFromRepository = planetRepository.findById(planet.getNode()).get();
       planetFromRepository.setName(planet.getName());
       planetRepository.save(planetFromRepository);
    }

    @Override
    public void delete(Planet planet) {
        planetRepository.delete(planet);
    }

    @Override
    public void saveAll(List<Planet> planets) {
        planetRepository.saveAll(planets);
    }
}
