package entity;

import interfaces.IGerenciaArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciaArquivo implements IGerenciaArquivo {

    List<Voo> flights = new ArrayList<>();

    @Override
    public List<Voo> listaDeVoos(String arquivo) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {
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
        return flights;
    }

    @Override
    public void escreveLinhas(String caminhoArquivo, List<Voo> conteudoArquivo) {
        Path caminho = Paths.get(caminhoArquivo);
        List<String> teste = conteudoArquivo.stream().map(voo -> voo.getOrigin() + ","
                + voo.getDestination() + "," + voo.getAirline() + ","
                + voo.getDeparture() + "," + voo.getArrival() + ","
                + voo.getPrice() + ","
                + voo.getDuration()).collect(Collectors.toList());
        teste.add(0, "origin,destination,airline,departure,arrival,price,time");
        try {
            Files.write(caminho, teste);
        } catch (IOException excecao) {
        }
    }
}