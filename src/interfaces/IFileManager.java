package interfaces;

import entity.Flight;

import java.util.List;

public interface IFileManager {

    List<Flight> flightList(String arquivo);

    void writeLines(String caminhoArquivo, List<Flight> conteudoArquivo);

}
