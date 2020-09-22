package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Planet;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Route;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Edge;
import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public List<Planet> readPlanetsFromFile(File file) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook apachePOIWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet firstSheetPlanets = apachePOIWorkbook.getSheetAt(0);
            List<Planet> planets = new ArrayList<>();
            Iterator<Row> iterator = firstSheetPlanets.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                if(checkIfRowIsEmpty(nextRow)){
                    break;
                }
                else if(nextRow.getRowNum() ==0) {
                    continue;
                }
                else {
                    planets.add(new Planet(
                            nextRow.getCell(0).getStringCellValue(),
                            nextRow.getCell(1).getStringCellValue()));
                }
            }
            return planets;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Route> readRoutesFromFile(File file) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook apachePOIWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet secondSheetRoutes = apachePOIWorkbook.getSheetAt(1);
            List<Route> routes = new ArrayList<>();
            Iterator<Row> iterator = secondSheetRoutes.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                if(checkIfRowIsEmpty(nextRow)){
                    break;
                }
                else if(nextRow.getRowNum() ==0) {
                    continue;
                }
                else {
                    routes.add(new Route(
                            (int)nextRow.getCell(0).getNumericCellValue(),
                            nextRow.getCell(1).getStringCellValue(),
                            nextRow.getCell(2).getStringCellValue(),
                            nextRow.getCell(3).getNumericCellValue()
                    ));
                }
            }
            return routes;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Boolean checkIfRowIsEmpty(Row row) {
            boolean isEmptyRow = true;
            for(int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++){
                Cell cell = row.getCell(cellNum);
                if(cell != null && cell.getCellType() != CellType.BLANK){
                    isEmptyRow = false;
                }
            }
            return isEmptyRow;
    }
}
