package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Planet {

    @Id
    private String planetNode;

    private String planetName;

    public Planet() {
    }

    public Planet(String planetNode, String planetName) {
        this.planetNode = planetNode;
        this.planetName = planetName;
    }

    public String getPlanetNode() {
        return planetNode;
    }

    public void setPlanetNode(String planetNode) {
        this.planetNode = planetNode;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(planetNode, planet.planetNode) &&
                Objects.equals(planetName, planet.planetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetNode, planetName);
    }
}
