package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Route {

    @Id
    private int id;
    private String originPlanetNode;
    private String destinationPlanetNode;
    private double distance;

    public Route() {
    }

    public Route(int id, String originPlanetNode, String destinationPlanetNode, double distance) {
        this.id = id;
        this.originPlanetNode = originPlanetNode;
        this.destinationPlanetNode = destinationPlanetNode;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginPlanetNode() {
        return originPlanetNode;
    }

    public void setOriginPlanetNode(String originPlanetNode) {
        this.originPlanetNode = originPlanetNode;
    }

    public String getDestinationPlanetNode() {
        return destinationPlanetNode;
    }

    public void setDestinationPlanetNode(String destinationPlanetNode) {
        this.destinationPlanetNode = destinationPlanetNode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                Double.compare(route.distance, distance) == 0 &&
                Objects.equals(originPlanetNode, route.originPlanetNode) &&
                Objects.equals(destinationPlanetNode, route.destinationPlanetNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originPlanetNode, destinationPlanetNode, distance);
    }
}
