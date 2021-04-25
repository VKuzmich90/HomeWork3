package models.users;

import models.Ticket;

import java.util.logging.Logger;

public class Passenger extends User {

    private final Ticket ticket;

    private static final Logger logger = Logger.getLogger(String.valueOf(Passenger.class));

    public Passenger(String firstName, String lastName, int age, Ticket ticket) {
        super(firstName, lastName, age);
        this.ticket = ticket;

        logger.info("Passenger was created");
    }

    public static Passenger of(String firstName, String lastName, int age, Ticket ticket) {
        return new Passenger(firstName, lastName, age, ticket);
    }

    public Ticket getTicket() {
        return ticket;
    }
}
