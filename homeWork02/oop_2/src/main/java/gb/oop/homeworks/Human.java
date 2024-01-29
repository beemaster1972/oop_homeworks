package gb.oop.homeworks;

import java.util.Random;

public class Human extends Creatures {
    private int maxRunDistance;
    private int maxJumpHeight;

    public Human(String name) {
        super(name);
        this.rand = new Random();
        this.maxRunDistance = setMaxValue(1000,100);
        this.maxJumpHeight = setMaxValue(200,50);

    }

    @Override
    public void overcoming(Obstacles obstacle) {
        int maxDimension = switch (obstacle.getDirection()) {
            case horizontal -> maxRunDistance;
            case vertical -> maxJumpHeight;
        };
        String action = switch (obstacle.getDirection()){
            case horizontal -> "пробежал дистанцию";
            case vertical -> "перепрыгул препятствие высотой";
        };
        if (obstacle.getDimension()>maxDimension) canContinue = false;
        if(!canContinue){
            System.out.printf("Человек %s не может продолжать гонку%n", getName());
            return;
        }
        System.out.printf("Человек %s %s %d %s",getName(),action,obstacle.getDimension(),obstacle.getUnit());

    }

}
