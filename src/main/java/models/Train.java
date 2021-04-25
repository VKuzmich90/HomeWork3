package models;

import models.carriages.Carriage;
import models.carriages.Locomotive;

import java.util.List;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public class Train {

    final private int number;

    private Locomotive locomotive;

    private static final Logger logger = Logger.getLogger(String.valueOf(Train.class));

    public Train(int number, Locomotive locomotive) {

        checkArgument(number > 0, "models.Train number must be positive");
        this.number = number;

        checkArgument(locomotive != null, "models.carriages.Locomotive must exist");
        this.locomotive = locomotive;

        logger.info("Train was created");
    }

    public static Train of(int number, Locomotive locomotive) {
        return new Train(number, locomotive);
    }

    public void addCarriage(Carriage carriage) {
        checkArgument(carriage != null, "models.carriages.Carriage must exist");

        addCarriages(List.of(carriage));
    }

    public void addCarriages(List<Carriage> carriages) {
        carriages.forEach(carriage -> checkArgument(carriage != null, "models.carriages.Carriage must exist"));

        Carriage tail = locomotive;
        while (tail.getNextCarriage() != null) {
            tail = tail.getNextCarriage();
        }

        for (Carriage carriage : carriages) {
            tail.setNextCarriage(carriage);
            tail = carriage;

            logger.info(String.format("%s = %s, Cargo = %s added", carriage.getClass(), carriage.getNumber()));
        }

    }

    public Carriage getCarriage(int number) {

        Carriage carriage = locomotive;
        number--;

        while (number > 0 && carriage != null) {
            carriage = carriage.getNextCarriage();
            number--;
        }

        checkArgument(carriage != null, "Carriage doesn't exist");

        return carriage;
    }

    public int getNumber() {
        return number;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public String toString() {
        return "models.Train{" +
                "number=" + number +
                ", locomotive=" + locomotive +
                '}';
    }
}
