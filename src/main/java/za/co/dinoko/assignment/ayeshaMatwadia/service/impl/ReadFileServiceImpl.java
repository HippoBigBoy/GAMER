package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
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
    public Map<String, Vertex> readDataFromExcelFileAndCreateVertexMap() {
     String fileName = "SupportData-V1.xlsx";
     try {
         FileInputStream fileInputStream = getFileFromResources(fileName);
         Workbook apachePOIWorkbook = new XSSFWorkbook(fileInputStream);
         Sheet firstSheet = apachePOIWorkbook.getSheetAt(0);
         Sheet secondSheet = apachePOIWorkbook.getSheetAt(1);
         Map<String, Vertex> verticesMap = createVerticesFromFileInputStream(firstSheet);
         Map<String, Vertex> verticesWithEdges = addEdgesToVertices(secondSheet, verticesMap);
        return verticesWithEdges;
     }catch(Exception e) {
         System.out.println("Find not found");
         throw new RuntimeException(e);
     }
    }

    private Map<String ,Vertex> createVerticesFromFileInputStream(Sheet firstSheet) throws IOException {
        Map<String, Vertex> vertices = new HashMap();
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if(checkIfRowIsEmpty(nextRow)){
             break;
            }
            else if(nextRow.getRowNum() ==0) {
               continue;
            }
            else {
               vertices.put(nextRow.getCell(0).getStringCellValue(),new Vertex(
                   nextRow.getCell(0).getStringCellValue(),
                   nextRow.getCell(1).getStringCellValue())
               );
            }
        }
        return vertices;
    }

    private Map<String, Vertex> addEdgesToVertices(Sheet secondSheet , Map<String, Vertex> vertices) {
        Iterator<Row> iterator = secondSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if(checkIfRowIsEmpty(nextRow)){
                break;
            }
            else if(nextRow.getRowNum() == 0) {
                continue;
            }
            else {
                String originVertexString = nextRow.getCell(1).getStringCellValue();
                String destinationVertexString = nextRow.getCell(2).getStringCellValue();
                double distance = nextRow.getCell(3).getNumericCellValue();
                if(!vertices.containsKey(originVertexString)){
                    vertices.put(originVertexString, new Vertex(originVertexString, UUID.randomUUID().toString()));
                }
                if(!vertices.containsKey(destinationVertexString)){
                    vertices.put(destinationVertexString, new Vertex(destinationVertexString, UUID.randomUUID().toString()));
                }
                Vertex originVertex = vertices.get(originVertexString);
                Vertex destinationVertex = vertices.get(destinationVertexString);
                originVertex.addNeighbour(new Edge(distance, originVertex, destinationVertex));
                vertices.put(originVertexString, originVertex);
//               making sure we add the reverse edge
                destinationVertex.addNeighbour(new Edge(distance, destinationVertex, originVertex));
                vertices.put(destinationVertexString, destinationVertex);
            }
        }
        return vertices;
    }

    private FileInputStream getFileFromResources(String nameOfFile) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(nameOfFile).getFile());
        return new FileInputStream(file);
    }

    private Boolean checkIfRowIsEmpty(Row row) {
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
