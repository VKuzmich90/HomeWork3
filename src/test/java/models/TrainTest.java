package models;

import models.carriages.CargoCarriage;
import models.carriages.Carriage;
import models.carriages.Locomotive;
import models.carriages.PassengerCarriage;
import models.users.Driver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class TrainTest {


    @Test
    public void of() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Driver driver = Driver.of("Vadzim", "Kuzmich", 30, true);

        Locomotive locomotive = Locomotive.of(123, cargoCarriage, driver);

        Train train = new Train(1000, locomotive);

        assertEquals(train.getLocomotive(), locomotive);
        assertEquals(train.getNumber(), 1000);

      }

    @Test
    public void addCarriage() {
        Train train = anyTrain();

        Locomotive locomotive = Locomotive.of(100, null, anyDriver());
        train.addCarriage(locomotive);

        assertEquals(train.getLocomotive(), locomotive);
    }

    @Test
    public void addCarriages() {
        Train train = anyTrain();

        Carriage fourthCarriage = PassengerCarriage.of(60, null, 75);
        Carriage thirdCarriage = PassengerCarriage.of(3, fourthCarriage, 50);
        Carriage secondCarriage = PassengerCarriage.of(2, thirdCarriage, 100);

        train.addCarriages(List.of(secondCarriage, thirdCarriage, fourthCarriage));

        assertEquals(train.getCarriage(2), secondCarriage);
        assertEquals(train.getCarriage(3), thirdCarriage);
        assertEquals(train.getCarriage(4), fourthCarriage);
    }

    private Train anyTrain() {
        CargoCarriage cargoCarriage = CargoCarriage.of(39, null , 100, 86);

        Driver driver = Driver.of("Vadzim", "Kuzmich", 30, true);

        Locomotive locomotive = Locomotive.of(123, cargoCarriage, driver);

        return new Train(1000, locomotive);
    }

    private Driver anyDriver() {
        Driver driver = Driver.of("Ivan", "Subbota", 30, true);
        return driver;
    }

}