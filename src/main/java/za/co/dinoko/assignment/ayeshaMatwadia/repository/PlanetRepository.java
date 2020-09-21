package za.co.dinoko.assignment.ayeshaMatwadia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {

}
