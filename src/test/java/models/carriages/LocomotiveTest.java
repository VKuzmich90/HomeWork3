package models.carriages;

import models.users.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocomotiveTest {

    @Test
    public void of() {
        Driver driver = Driver.of("Vadzim", "Kuzmich", 30, true);

        Locomotive locomotive = Locomotive.of(123, null, driver);

        assertEquals(locomotive.getNumber(), 123);

        assertEquals(locomotive.getDriver(), driver);

        assertNotSame(locomotive, new Locomotive(123, null, driver));
    }


}