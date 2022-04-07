import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\Juh\\IdeaProjects\\FlightInformation\\flights.csv";
        List<Voo> flights = new ArrayList<Voo>();

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
//
//        for (Voo v : flights) {
//            System.out.println(v);
//        }

        //lista ordenada por origem
        flights.stream()
                .sorted(Comparator.comparing(Voo::getOrigin))
        .forEach(System.out::println);



    }
}

