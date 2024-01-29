package gb.oop.homeworks;

public class Barrier extends Obstacles{
    public Barrier(String name, int dimension, Directions direction) {
        super(name, dimension, direction);
    }

    @Override
    String getUnit() {
        return "см";
    }
}

