package models.carriages;

public abstract class Carriage {

    private final int number;

    protected Carriage nextCarriage;

    public Carriage(int number, Carriage nextCarriage) {
        this.number = number;
        this.nextCarriage = nextCarriage;
    }

    public int getNumber() {
        return number;
    }

    public Carriage getNextCarriage() {
        return nextCarriage;
    }

    public void setNextCarriage(Carriage nextCarriage) {
        this.nextCarriage = nextCarriage;
    }

    @Override
    public String toString() {
        return "models.carriages.Carriage{" +
                "number=" + number +
                ", nextCarriage=" + nextCarriage +
                '}';
    }
}
