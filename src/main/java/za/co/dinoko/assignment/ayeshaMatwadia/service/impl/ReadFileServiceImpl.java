package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.service.ReadFileService;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public void readDataFromExcelFile() {
     String fileName = "SupportData-V1.xlsx";
     ClassLoader classLoader = getClass().getClassLoader();
     try{
         File file = new File(classLoader.getResource(fileName).getFile());
         System.out.println("File found !");
         FileInputStream inputStream = new FileInputStream(file);

         Workbook apachePOIWorkbook = new XSSFWorkbook(inputStream);
         Sheet firstSheet = apachePOIWorkbook.getSheetAt(0);
         Iterator<Row> iterator = firstSheet.iterator();
         while (iterator.hasNext()) {
             Row nextRow = iterator.next();
             if(checkIfRowIsEmpty(nextRow)){
              break;
             }else {
                 Iterator<Cell> cellIterator = nextRow.cellIterator();
                 while (cellIterator.hasNext()) {
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) {
                         case STRING:
                             System.out.print(cell.getStringCellValue());
                             break;
                         case BOOLEAN:
                             System.out.print(cell.getBooleanCellValue());
                             break;
                         case NUMERIC:
                             System.out.print(cell.getNumericCellValue());
                             break;
                     }
                     System.out.print(" - ");
                 }
                 System.out.println();
             }
         }
     }catch(Exception e) {
         System.out.println("Find not found");
     }
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
