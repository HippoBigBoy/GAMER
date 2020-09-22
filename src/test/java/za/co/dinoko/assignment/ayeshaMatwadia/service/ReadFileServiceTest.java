package za.co.dinoko.assignment.ayeshaMatwadia.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.dinoko.assignment.ayeshaMatwadia.TestData;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;

import java.io.File;
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
        assert(planetList.equals(TestData.PlanetData1()));
    }

    @Test
    public void readingAValidAndPopulatedPlanetRoutesFromFileShouldReturnAListOfRoutes(){
        File emptyExcelFile = getFile("MockTestData1.xlsx");
        List<Route> routeList =  readFileService.readRoutesFromFile(emptyExcelFile);
        assertFalse(routeList.isEmpty());
        assert(routeList.equals(TestData.routeData1()));
    }

    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
