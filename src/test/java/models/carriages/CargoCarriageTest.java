package models.carriages;

import models.Cargo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CargoCarriageTest {

    @Test
    public void of() {
        Cargo cargo1 = Cargo.of(19);
        Cargo cargo2 = Cargo.of(13);


        CargoCarriage cargoCarriage0 = CargoCarriage.of(39, null , 100, 86);
        CargoCarriage cargoCarriage = CargoCarriage.of(40, cargoCarriage0, 100, 13);

        assertEquals(cargoCarriage.getCapacity(), 100);
        assertEquals(cargoCarriage.getFullness(), 13);

        assertNull(cargoCarriage.getNextCarriage());

        assertEquals(cargoCarriage.getCargos(), List.of(cargo1, cargo2));
    }

    @Test
    public void addCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Cargo cargo = Cargo.of(9);

        cargoCarriage.loadCargo(cargo);
        Assert.assertTrue(cargoCarriage.contains(cargo));
    }

    @Test
    public void addCargos() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Cargo cargo1 = Cargo.of(19);
        Cargo cargo2 = Cargo.of(13);

        cargoCarriage.loadCargos(List.of(cargo1, cargo2));

        Assert.assertTrue(cargoCarriage.contains(cargo1));
        Assert.assertTrue(cargoCarriage.contains(cargo2));
    }

    @Test
    public void unloadCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Cargo cargo = Cargo.of(19);

        cargoCarriage.loadCargo(cargo);
        Assert.assertTrue(cargoCarriage.contains(cargo));

        cargoCarriage.unloadCargo(cargo);
        Assert.assertFalse(cargoCarriage.contains(cargo));
    }

    @Test
    public void unloadCargos() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Cargo cargo1 = Cargo.of(19);
        Cargo cargo2 = Cargo.of(13);

        cargoCarriage.loadCargos(List.of(cargo1, cargo2));

        Assert.assertTrue(cargoCarriage.contains(cargo1));
        Assert.assertTrue(cargoCarriage.contains(cargo2));

        cargoCarriage.unloadCargos(List.of(cargo1, cargo2));

        Assert.assertFalse(cargoCarriage.contains(cargo1));
        Assert.assertFalse(cargoCarriage.contains(cargo2));
    }

    @Test
    public void containsCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Cargo cargo1 = Cargo.of(19);
        Cargo cargo2 = Cargo.of(13);

        Assert.assertFalse(cargoCarriage.contains(cargo1));
        Assert.assertFalse(cargoCarriage.contains(cargo2));

        cargoCarriage.loadCargo(cargo1);
        Assert.assertTrue(cargoCarriage.contains(cargo1));

        cargoCarriage.loadCargo(cargo2);
        Assert.assertTrue(cargoCarriage.contains(cargo2));
    }

}