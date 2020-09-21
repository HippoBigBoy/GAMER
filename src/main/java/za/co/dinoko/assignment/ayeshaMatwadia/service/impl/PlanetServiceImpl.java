package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.PlanetRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetService;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    PlanetRepository planetRepository;

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
//        Todo handle the option below better
       Planet planetFromRepository = planetRepository.findById(planet.getPlanetNode()).get();
       planetFromRepository.setPlanetName(planet.getPlanetName());
       planetRepository.save(planetFromRepository);
    }

    @Override
    public void delete(Planet planet) {
        planetRepository.delete(planet);
    }
}
