package models;

import java.util.UUID;
import java.util.logging.Logger;

public class Cargo {

    final private String id;

    final private int weight;

    private static final Logger logger = Logger.getLogger(String.valueOf(Cargo.class));

    public Cargo(int weight) {
        this.id = UUID.randomUUID().toString();
        this.weight = weight;

        logger.info("Cargo was created");
    }

    public static Cargo of(int weight) {
        return new Cargo(weight);
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "models.Cargo{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }
}
