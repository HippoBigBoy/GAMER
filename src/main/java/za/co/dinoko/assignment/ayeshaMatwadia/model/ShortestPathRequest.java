package za.co.dinoko.assignment.ayeshaMatwadia.model;

public class ShortestPathRequest {

    String startPlanet;
    String destinationPlanet;

    public ShortestPathRequest() {
    }

    public ShortestPathRequest(String startPlanet, String destinationPlanet) {
        this.startPlanet = startPlanet;
        this.destinationPlanet = destinationPlanet;
    }

    public String getStartPlanet() {
        return startPlanet;
    }

    public void setStartPlanet(String startPlanet) {
        this.startPlanet = startPlanet;
    }

    public String getDestinationPlanet() {
        return destinationPlanet;
    }

    public void setDestinationPlanet(String destinationPlanet) {
        this.destinationPlanet = destinationPlanet;
    }
}
