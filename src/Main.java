import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        for (Voo v : flights) {
//            System.out.println(v);
//        }

            //flights.stream().filter(voo -> voo.getOrigin().equals(voo.getOrigin())).map()

        Stream<Voo> agrupamento = flights.stream().filter(Voo -> Voo.getOrigin().equals("KIN-Jamaica"));
        System.out.println(agrupamento);
    }
}

