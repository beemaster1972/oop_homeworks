package gb.oop.homeworks;

import java.util.Random;

public abstract class Creatures implements SportInterface{
    protected String name;
    protected Random rand;
    protected boolean canContinue;

    public Creatures(String name) {
        this.name = name;
        this.canContinue = true;
        rand = new Random();
    }

    public String getName() {
        return name;
    }

    public int setMaxValue(int max, int min){
        return rand.nextInt(max+min+1)-min+1;
    }


}
