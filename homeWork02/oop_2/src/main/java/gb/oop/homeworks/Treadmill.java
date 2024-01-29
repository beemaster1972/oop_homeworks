package gb.oop.homeworks;

public class Treadmill extends Obstacles{
    private int index;
    public Treadmill(String name, int dimension, Directions direction) {
        super(name, dimension, direction);
    }

    public Treadmill() {
        this(setDefaultName(), )
    }

    private static Object setDefaultName() {
    }

    @Override
    String getUnit() {
        return "метров";
    }
}
