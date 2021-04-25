package models.users;

import models.Ticket;
import models.Train;

import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public class Driver extends User{

    private boolean license;

    private static final Logger logger = Logger.getLogger(String.valueOf(Driver.class));

    public Driver(String firstName, String lastName, int age, boolean license) {
        super(firstName, lastName, age);

        checkArgument(age >= 18,"models.users.Driver age must be >= 18");
        this.age = age;

        checkArgument(license, "models.users.Driver must have a license");
        this.license = license;

        logger.info("Driver was created");
    }

    public static Driver of(String firstName, String lastName, int age, boolean license) {
        return new Driver(firstName, lastName, age, license);
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }
}
