package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.repository.PlanetRepository;
import za.co.dinoko.assignment.ayeshaMatwadia.service.PlanetCRUDService;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetCRUDServiceImpl implements PlanetCRUDService {

    @Autowired
    PlanetRepository planetRepository;

    @Override
    public void create(String planetNode, String planetName) {
       planetRepository.save(new Planet(planetNode, planetName));
    }

    @Override
    public List<Planet> read() {
        return planetRepository.findAll();
    }

    @Override
    public void update(String planetNode, String planetName) {
//        Todo handle the option below better
       Planet planetFromRepository = planetRepository.findById(planetNode).get();
       planetFromRepository.setPlanetNode(planetNode);
       planetFromRepository.setPlanetName(planetName);
       planetRepository.save(planetFromRepository);
    }

    @Override
    public void delete(String planetNode) {
        planetRepository.deleteById(planetNode);
    }
}
