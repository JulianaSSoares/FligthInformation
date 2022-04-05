import java.time.OffsetTime;

public class Voo {
    private String origin;
    private String destination;
    private String airline;
    private String departure;
    private String arrival;
    private double price;

    public Voo(String origin, String destination, String airline, String departure, String arrival, double price) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public String getAirline() { return airline; }

    public void setAirline(String airline) { this.airline = airline; }

    public String getDeparture() { return departure; }

    public void setDeparture(String departure) { this.departure = departure; }

    public String getArrival() { return arrival; }

    public void setArrival(String arrival) { this.arrival = arrival; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Voo{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", price=" + price +
                '}';
    }
}
