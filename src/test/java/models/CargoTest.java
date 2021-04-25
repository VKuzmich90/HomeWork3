package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    public void of() {
        Cargo cargo1 = new Cargo(100);
        Cargo cargo2 = Cargo.of(100);

        assertEquals(cargo1.getWeight(), cargo2.getWeight());

        assertNotSame(cargo1, cargo2);
    }

}