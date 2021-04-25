package models.carriages;

import models.Cargo;
import models.users.Driver;
import models.users.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public class PassengerCarriage extends Carriage{

    private  List<Passenger> passengers;

    private final int capacity;

    private int fullness;

    private static final Logger logger = Logger.getLogger(String.valueOf(PassengerCarriage.class));

    public PassengerCarriage(int number, Carriage nextCarriage, int capacity) {
        super(number, nextCarriage);
        this.capacity = capacity;
        this.passengers = new ArrayList<Passenger>();

        logger.info("Passenger carriage was created");
    }

    public static PassengerCarriage of(int number, Carriage nextCarriage, int capacity) {
        return new PassengerCarriage(number, nextCarriage, capacity);
    }

    public void addPassenger(Passenger passenger) {
        int placeNumber = passenger.getTicket().getPlaceNumber();

        checkArgument(placeNumber <= capacity,
                "Place number must be <= capacity");

        checkArgument(passengers.get(placeNumber - 1) == null,
                "Seat occupied");

        this.passengers.add(placeNumber - 1, passenger);
        fullness++;
    }

    public void addPassengers(List<Passenger> passengers) {
        checkArgument(passengers != null, "Passengers must exist");

        passengers.forEach(this:: addPassenger);
    }


    public void deletePassenger(Passenger passenger) {
        int placeNumber = passenger.getTicket().getPlaceNumber();

        checkArgument(placeNumber <= capacity,
                "Place number must be <= capacity");

        checkArgument(passengers.get(placeNumber - 1) != null,
                "Seat is free");

        this.passengers.remove(placeNumber - 1);
        fullness--;
    }

    public void deletePassengers(List<Passenger> passengers) {
        checkArgument(passengers != null, "Passengers must exist");

        passengers.forEach(this:: deletePassenger);
    }

    public boolean contains(Passenger passenger) {
        return this.passengers.contains(passenger);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFullness() {
        return fullness;
    }
}
