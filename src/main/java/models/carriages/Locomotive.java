package models.carriages;

import models.users.Driver;

import java.util.logging.Logger;

public class Locomotive extends Carriage{

private final Driver driver;

    private static final Logger logger = Logger.getLogger(String.valueOf(Locomotive.class));


    public Locomotive(int number, Carriage nextCarriage, Driver driver) {
        super(number, nextCarriage);
        this.driver = driver;

        logger.info("Locomotive was created");
    }

    public static Locomotive of(int number, Carriage nextCarriage, Driver driver) {
        return new Locomotive(number, nextCarriage, driver);
    }

    public Driver getDriver() {
        return driver;
    }


}
