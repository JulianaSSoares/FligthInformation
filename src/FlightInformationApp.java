import entity.FileManager;
import entity.Flight;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class FlightInformationApp {
    public static void main(String[] args) {
        String path = "flights.csv";
        FileManager fileManager = new FileManager();

        List<Flight> flights;
        flights = fileManager.flightList(path);

        //lista ordenada por origem/destino
        List<Flight> orderedList = flights.stream().sorted
                        (comparing(Flight::getOrigin)
                                .thenComparing(Flight::getDestination)
                                .thenComparing(Flight::getDuration)
                                .thenComparing(Flight::getPrice)
                                .thenComparing(Flight::getAirline))
                .collect(Collectors.toList());

        //criando arquivo csv
        fileManager.writeLines("ordered_list.csv", orderedList);

        //2º arquivo: origin;destination;shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price


    }
}