package interfaces;

import entity.Flight;

import java.util.List;

public interface IFileManager {

    List<Flight> flightList(String file);
    void writeLines(String filePath, List<Flight> fileContent);

}
