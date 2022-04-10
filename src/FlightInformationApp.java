import entity.CriarArquivo;
import entity.Voo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FlightInformationApp {
    public static void main(String[] args) {
        CriarArquivo.CriaArquivo criarArquivo = new CriarArquivo.CriaArquivo();

        String path = "C:\\Users\\Juh\\IdeaProjects\\FlightInformation\\flights.csv";
        List<Voo> flights = new ArrayList<Voo>();

        //leitura do arquivo csv
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            while (line != null) {
                String[] array = line.split(";");

                String origin = array[0];
                String destination = array[1];
                String airline = array[2];
                String departure = array[3];
                String arrival = array[4];
                Double price = Double.valueOf(array[5]);

                Voo voo = new Voo(origin, destination, airline, departure, arrival, price);

                flights.add(voo);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //lista ordenada por origem/destino
        List<Voo> listaOrdenada = flights.stream().sorted(Comparator.comparing(Voo::getOrigin)
                .thenComparing(Voo::getDestination)
                .thenComparing(Voo::getAirline)
                .thenComparing(Voo::getPrice)
                .thenComparing(Voo::getDuration)).collect(Collectors.toList());

        //criando arquivo csv
        criarArquivo.escreveLinhas("lista_ordenada.csv",listaOrdenada);

    }
}