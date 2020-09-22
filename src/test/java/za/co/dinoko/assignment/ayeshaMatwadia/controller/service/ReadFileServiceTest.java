package za.co.dinoko.assignment.ayeshaMatwadia.controller.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReadFileServiceTest {

    @Autowired
    ReadFileService readFileService;

    @Test
    public void passingNullAsFileToReadPlanetsThrowsException(){
        assertThrows(Exception.class,
                () -> readFileService.readPlanetsFromFile(null));
    }

    @Test
    public void passingNullAsFileToReadRoutesThrowsException(){
        assertThrows(Exception.class,
                () -> readFileService.readRoutesFromFile(null));
    }

    @Test
    public void emptyExcelFileWithFirstSheetReturnsAnEmptyListOfPlanets(){
        File emptyExcelFile = getFile("TestEmptyExcelDocument.xlsx");
        List<Planet> planetList =  readFileService.readPlanetsFromFile(emptyExcelFile);
        assertTrue(planetList.isEmpty());
    }

    @Test
    public void emptyExcelFileWithSecondSheetReturnsAnEmptyListOfRoutes(){
        File emptyExcelFile = getFile("TestEmptyExcelDocument.xlsx");
        List<Route> routes =  readFileService.readRoutesFromFile(emptyExcelFile);
        assertTrue(routes.isEmpty());
    }

    @Test
    public void tryingToReadRoutesFromAnExcelFileWithoutASecondSheetThrowsException(){
        assertThrows(RuntimeException.class,
                () -> readFileService.readRoutesFromFile(getFile("OneSheetExcelDocument.xlsx")),
                "");
    }

    @Test
    public void readingAValidAndPopulatedPlanetNamesFileShouldReturnAListOfPlants(){
        File emptyExcelFile = getFile("MockTestData1.xlsx");
        List<Planet> planetList =  readFileService.readPlanetsFromFile(emptyExcelFile);
        assertFalse(planetList.isEmpty());
        assert(planetList.equals(getExpectedPlanetsMockData1()));
    }

    @Test
    public void readingAValidAndPopulatedPlanetRoutesFromFileShouldReturnAListOfRoutes(){
        File emptyExcelFile = getFile("MockTestData1.xlsx");
        List<Route> routeList =  readFileService.readRoutesFromFile(emptyExcelFile);
        assertFalse(routeList.isEmpty());
        assert(routeList.equals(getExpectedRouteMockData1()));
    }

    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    private List<Planet> getExpectedPlanetsMockData1() {
        List<Planet> expectedPlanets = new ArrayList<>();
        expectedPlanets.add(new Planet("A", "Earth"));
        expectedPlanets.add(new Planet("B"   , "Moon"));
        expectedPlanets.add(new Planet("C", "Jupiter"));
        expectedPlanets.add(new Planet("D", "Venus"));
        expectedPlanets.add(new Planet("E", "Mars"));
        return expectedPlanets;
    }

    private List<Route> getExpectedRouteMockData1() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(1, "A", "B", 0.44));
        routes.add(new Route(2, "A", "C", 1.89));
        routes.add(new Route(3, "A", "D", 0.10));
        routes.add(new Route(4, "B", "H", 2.44));
        routes.add(new Route(5, "B", "E", 3.45));
        routes.add(new Route(6, "C", "F", 0.49));
        routes.add(new Route(7, "D", "L", 2.34));
        routes.add(new Route(8, "D", "M", 2.61));
        routes.add(new Route(10, "E", "I", 8.09));
        return routes;
    }
}
