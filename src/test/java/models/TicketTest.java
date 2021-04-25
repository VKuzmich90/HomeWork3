package models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TicketTest {

    @Test
    public void equals() {

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Ticket ticket2 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Ticket ticket3 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);

        assertEquals(ticket1, ticket1);

        assertEquals(ticket1.equals(ticket2), ticket2.equals(ticket1));

        if (ticket1.equals(ticket2) == ticket2.equals(ticket3)) {
            assertEquals(ticket1, ticket3);
        }
        else {
            assertNotEquals(ticket1, ticket3);
        }

        assertEquals(ticket1.equals(ticket2), ticket1.equals(ticket2));

        assertNotEquals(null, ticket1);

        ticket2 = Ticket.of("Brest", new Date(), "Minsk", new Date(), 5, 43);

        assertNotEquals(ticket1, ticket2);
        assertNotEquals(ticket3, ticket2);

        ticket2 = Ticket.of("Brest", new Date(), "Minsk", new Date(), 7, 4);

        assertNotEquals(ticket1, ticket2);
        assertNotEquals(ticket3, ticket2);

        ticket2 = Ticket.of("Grodno", new Date(), "Minsk", new Date(), 5, 43);

        assertNotEquals(ticket1, ticket2);
        assertNotEquals(ticket3, ticket2);

        ticket2 = Ticket.of("Brest", new Date(), "Vitebsk", new Date(), 5, 43);

        assertNotEquals(ticket1, ticket2);
        assertNotEquals(ticket3, ticket2);
    }

}