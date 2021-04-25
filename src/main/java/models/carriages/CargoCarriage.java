package models.carriages;

import models.Cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public class CargoCarriage extends Carriage {

    private final int capacity;

    private int fullness;

    private List<Cargo> cargos;

    private static final Logger logger = Logger.getLogger(String.valueOf(CargoCarriage.class));

    public CargoCarriage(int number, Carriage nextCarriage, int capacity, int fullness) {

        super(number, nextCarriage);
        this.capacity = capacity;
        this.fullness = fullness;
        this.cargos = new ArrayList<>();

        logger.info("Cargo carriage was created");
    }

    public static CargoCarriage of(int number, Carriage nextCarriage, int capacity, int fullness) {
        return new CargoCarriage(number, nextCarriage, capacity, fullness);
    }

    public void loadCargo(Cargo cargo) {
        checkArgument(fullness + cargo.getWeight() <= capacity,
                "models.carriages.Carriage is full");

        this.cargos.add(cargo);
        fullness += cargo.getWeight();
    }

    public void unloadCargo(Cargo cargo) {
        checkArgument(this.cargos.contains(cargo), "There is no such cargo");

        this.cargos.remove(cargo);
        fullness -= cargo.getWeight();
    }

    public void  loadCargos(List<Cargo> cargos) {
       checkArgument(cargos != null, "Cargos must exist");

       cargos.forEach(this:: loadCargo);
    }

    public void  unloadCargos(List<Cargo> cargos) {
        checkArgument(cargos != null, "Cargos must exist");

        cargos.forEach(this:: unloadCargo);
    }

    public boolean contains(Cargo cargo) {
        return this.cargos.contains(cargo);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFullness() {
        return fullness;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }
}
