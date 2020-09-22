# intersteller
Imagine you are on a ship in the near future navigating the galaxy. You want to calculate the shortest distance between 2 planets given the distances between every other connecting planet between them. In short this is a Java Spring Boot Hibernate application that implements the shortest path algorithm in a fun way

# how to run this program
from your terminal cd into the root

run

mvn clean install

mvn spring-boot:run

# how to run tests
(windows)

.\mvnw test

# Your JSON Requests
POST
http://localhost:8080/shortestPath

{
	"startPlanet": "A",
	"destinationPlanet": "B"
}