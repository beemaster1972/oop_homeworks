package gb.oop.homeworks;

/**
 * Класс Барьер
 * Направление - вертикально
 * Измерение - высота
 * Ед. изм. - сантиметры
 */
public class Barrier extends Obstacles{
    final private static int MAX_HEIGHT = 300;
    final private static int MIN_HEIGHT = 10;

    private static int barrierIndex;

    static{
        barrierIndex=0;
    }
    public Barrier(String name, int dimension, Directions direction) {
        super(name, dimension, direction);
    }

    public Barrier(){

        this(setDefaultName("Барьер",++barrierIndex), setRandomDimension(MAX_HEIGHT,MIN_HEIGHT),Directions.vertical);
    }

    @Override
    String getUnit() {
        return "см";
    }
}

