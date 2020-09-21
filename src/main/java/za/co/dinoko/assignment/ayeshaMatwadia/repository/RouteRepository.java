package za.co.dinoko.assignment.ayeshaMatwadia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

}
