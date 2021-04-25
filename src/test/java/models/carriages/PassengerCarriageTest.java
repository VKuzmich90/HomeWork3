package models.carriages;

import models.Cargo;
import models.Ticket;
import models.users.Passenger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerCarriageTest {

    @Test
    public void of() {

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Ticket ticket2 = new Ticket("Brest", new Date(), "Minsk", new Date(), 1, 4);

        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);
        Passenger passenger2 = Passenger.of("Daniil", "Shukevich", 31, ticket2);

        PassengerCarriage passengerCarriage0 = PassengerCarriage.of(1, null, 54);
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, passengerCarriage0, 54);


        assertEquals(passengerCarriage.getCapacity(), 54);
        assertEquals(passengerCarriage.getNumber(), 1);

        assertNull(passengerCarriage.getNextCarriage());

        assertEquals(passengerCarriage.getPassengers(), List.of(passenger1, passenger2));
    }

    @Test
    public void addPassenger() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, null, 54);

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);

        passengerCarriage.addPassenger(passenger1);
        Assert.assertTrue(passengerCarriage.contains(passenger1));
    }

    @Test
    public void addPassengers() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, null, 54);

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);

        Ticket ticket2 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 42);
        Passenger passenger2 = Passenger.of("Daniil", "Shunkevich", 31, ticket2);


        passengerCarriage.addPassengers(List.of(passenger1, passenger2));

        Assert.assertTrue(passengerCarriage.contains(passenger1));
        Assert.assertTrue(passengerCarriage.contains(passenger2));
    }

    @Test
    public void deletePassenger() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, null, 54);

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);

        passengerCarriage.addPassenger(passenger1);
        Assert.assertTrue(passengerCarriage.contains(passenger1));

        passengerCarriage.deletePassenger(passenger1);
        Assert.assertFalse(passengerCarriage.contains(passenger1));
    }

    @Test
    public void deletePassengers() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, null, 54);

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);

        Ticket ticket2 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 42);
        Passenger passenger2 = Passenger.of("Daniil", "Shunkevich", 31, ticket2);

        passengerCarriage.addPassengers(List.of(passenger1, passenger2));

        Assert.assertTrue(passengerCarriage.contains(passenger1));
        Assert.assertTrue(passengerCarriage.contains(passenger2));

        passengerCarriage.deletePassengers(List.of(passenger1, passenger2));

        Assert.assertFalse(passengerCarriage.contains(passenger1));
        Assert.assertFalse(passengerCarriage.contains(passenger2));
    }

    @Test
    public void containsPassener() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(1, null, 54);

        Ticket ticket1 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 43);
        Passenger passenger1 = Passenger.of("Vadzim", "Kuzmich", 30, ticket1);

        Ticket ticket2 = new Ticket("Brest", new Date(), "Minsk", new Date(), 5, 42);
        Passenger passenger2 = Passenger.of("Daniil", "Shunkevich", 31, ticket2);

        Assert.assertFalse(passengerCarriage.contains(passenger1));
        Assert.assertFalse(passengerCarriage.contains(passenger2));

        passengerCarriage.addPassenger(passenger1);
        Assert.assertTrue(passengerCarriage.contains(passenger1));

        passengerCarriage.addPassenger(passenger2);
        Assert.assertTrue(passengerCarriage.contains(passenger2));

    }

}