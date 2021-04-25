package models.users;

import models.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    public void of() {

        Driver driver1 = new Driver("Vadzim", "Kuzmich", 30, true);

        Driver driver2 = Driver.of("Vadzim", "Kuzmich", 30, true);

        assertEquals(driver1.getAge(), driver2.getAge());

        assertEquals(driver1.getFirstName(), driver2.getFirstName());

        assertEquals(driver1.getLastName(), driver2.getLastName());

        assertEquals(driver1.getLastName(), driver2.getLastName());

        assertEquals(driver1.isLicense(), driver2.isLicense());

        assertNotSame(driver1, driver2);

    }

}