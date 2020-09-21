package za.co.dinoko.assignment.ayeshaMatwadia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

    @Id
    private int routeId;

    private String planetOrigin;

    private String planetDestination;

    private double distanceLightYears;

    public Route() {
    }

    public Route(int routeId, String planetOrigin, String planetDestination, double distanceLightYears) {
        this.routeId = routeId;
        this.planetOrigin = planetOrigin;
        this.planetDestination = planetDestination;
        this.distanceLightYears = distanceLightYears;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getPlanetOrigin() {
        return planetOrigin;
    }

    public void setPlanetOrigin(String planetOrigin) {
        this.planetOrigin = planetOrigin;
    }

    public String getPlanetDestination() {
        return planetDestination;
    }

    public void setPlanetDestination(String planetDestination) {
        this.planetDestination = planetDestination;
    }

    public double getDistanceLightYears() {
        return distanceLightYears;
    }

    public void setDistanceLightYears(double distanceLightYears) {
        this.distanceLightYears = distanceLightYears;
    }
}
