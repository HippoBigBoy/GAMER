package za.co.dinoko.assignment.ayeshaMatwadia.service;

import za.co.dinoko.assignment.ayeshaMatwadia.model.Vertex;
import java.util.Map;

public interface ReadFileService {
    public Map<String, Vertex> readDataFromExcelFileAndCreateVertexMap();
}
