package gb.oop.homeworks;

import java.util.Random;

public abstract class Obstacles {
    protected String name;
    protected enum Directions {
        vertical, horizontal
    }
    protected int dimension;
    protected Directions direction;
    protected static Random rand;
    static {
        rand = new Random();
    }


    public Obstacles(String name, int dimension, Directions direction) {
        this.name = name;
        this.dimension = dimension;
        this.direction = direction;

    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }

    public Directions getDirection() {
        return direction;
    }

    public static int setRandomDimension(int max, int min){
        return rand.nextInt(max+min+1)-min+1;
    }
    abstract String getUnit();
}
