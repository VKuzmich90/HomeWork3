package models.users;

import models.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    public void of() {

        Ticket ticket = Ticket.of("Brest", new Date(), "Minsk", new Date(), 5, 43);

        Passenger passenger1 = new Passenger("Vadzim", "Kuzmich", 30, ticket);

        Passenger passenger2 = Passenger.of("Vadzim", "Kuzmich", 30, ticket);

        assertEquals(passenger1.getTicket(), ticket);

        assertEquals(passenger1.getAge(), passenger2.getAge());

        assertEquals(passenger1.getFirstName(), passenger2.getFirstName());

        assertEquals(passenger1.getLastName(), passenger2.getLastName());

        assertNotSame(passenger1, passenger2);

    }

}