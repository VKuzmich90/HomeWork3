package models;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public class Ticket {

    private final String id;

    private final String departurePlace;
    private final Date departureDate;

    private final String destination;
    private final Date destinationDate;

    private final int carriageNumber;
    private final int placeNumber;

    private static final Logger logger = Logger.getLogger(String.valueOf(Ticket.class));

    public Ticket(String departurePlace, Date departureDate, String destination, Date destinationDate, int carriageNumber, int placeNumber) {
        this.id = UUID.randomUUID().toString();

        this.departurePlace = departurePlace;
        this.departureDate = departureDate;

        this.destination = destination;
        this.destinationDate = destinationDate;

        checkArgument(carriageNumber > 0, "models.carriages.Carriage number must be positive");
        this.carriageNumber = carriageNumber;

        checkArgument(placeNumber > 0, "Place number must be positive");
        this.placeNumber = placeNumber;

        logger.info("Ticket was created");

    }

    public static Ticket of(String departurePlace, Date departureDate, String destination, Date destinationDate, int carriageNumber, int placeNumber) {
        return new Ticket(departurePlace, departureDate, destination, destinationDate, carriageNumber, placeNumber);
    }

    public String getId() {
        return id;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return carriageNumber == ticket.carriageNumber &&
                placeNumber == ticket.placeNumber &&
                Objects.equals(id, ticket.id) &&
                Objects.equals(departurePlace, ticket.departurePlace) &&
                Objects.equals(departureDate, ticket.departureDate) &&
                Objects.equals(destination, ticket.destination) &&
                Objects.equals(destinationDate, ticket.destinationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departurePlace, departureDate, destination, destinationDate, carriageNumber, placeNumber);
    }

    @Override
    public String toString() {
        return "models.Ticket{" +
                "id='" + id + '\'' +
                ", departurePlace='" + departurePlace + '\'' +
                ", departureDate=" + departureDate +
                ", destination='" + destination + '\'' +
                ", destinationDate=" + destinationDate +
                ", carriageNumber=" + carriageNumber +
                ", placeNumber=" + placeNumber +
                '}';
    }
}
