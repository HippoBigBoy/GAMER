package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.entities.Vertex;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public Map<String ,Vertex> readDataFromExcelFileAndCreateVertexMap() {
     String fileName = "SupportData-V1.xlsx";
     try {
         FileInputStream fileInputStream = getFileFromResources(fileName);
         Map<String, Vertex> vertices = createVerticesFromFileInputStream(fileInputStream);
         return vertices;
     }catch(Exception e) {
         System.out.println("Find not found");
         throw new RuntimeException("IO Exception");
     }
    }

    private Map<String ,Vertex> createVerticesFromFileInputStream(FileInputStream fileInputStream) throws IOException {
        Map<String, Vertex> vertices = new HashMap();
        Workbook apachePOIWorkbook = new XSSFWorkbook(fileInputStream);
        Sheet firstSheet = apachePOIWorkbook.getSheetAt(0);
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

//    private List<Vertex> addEdgesToVertices(List<Vertex> vertices) {
//
//        ???
//    }

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
