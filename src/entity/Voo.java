package entity;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Voo {
    private String origin;
    private String destination;
    private String airline;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;
    private double price;
    private long duration;

    public Voo(String origin, String destination, String airline, String departure, String arrival, double price) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = ZonedDateTime.parse(departure, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss '('zzz')'"));
        this.arrival = ZonedDateTime.parse(arrival, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss '('zzz')'"));
        this.price = price;

        duration = this.departure.until(this.arrival, ChronoUnit.HOURS);
    }
    public Voo(){ }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getAirline() {
        return airline;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public ZonedDateTime getArrival() {
        return arrival;
    }

    public double getPrice() {
        return price;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}