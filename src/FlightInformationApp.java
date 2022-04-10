import entity.GerenciaArquivo;
import entity.Voo;
import java.util.*;
import java.util.stream.Collectors;

public class FlightInformationApp {
    public static void main(String[] args) {
        String path = "C:\\Users\\Juh\\IdeaProjects\\FlightInformation\\flights.csv";
        GerenciaArquivo gerenciaArquivo = new GerenciaArquivo();

        List<Voo> flights;
        flights = gerenciaArquivo.listaDeVoos(path);

        //lista ordenada por origem/destino
        List<Voo> listaOrdenada = flights.stream().sorted(Comparator.comparing(Voo::getOrigin)
                .thenComparing(Voo::getDestination)
                .thenComparing(Voo::getAirline)
                .thenComparing(Voo::getPrice)
                .thenComparing(Voo::getDuration))
                .collect(Collectors.toList());

        //criando arquivo csv
        gerenciaArquivo.escreveLinhas("lista_ordenada.csv", listaOrdenada);

    }
}