package gb.oop.homeworks;

public class Answer {
    private Integer attemptCounter;
    private Integer cowCounter;
    private Integer bullCounter;

    public Answer(Integer attemptCounter, Integer cowCounter, Integer bullCounter) {
        this.attemptCounter = attemptCounter;
        this.cowCounter = cowCounter;
        this.bullCounter = bullCounter;
    }

    public Integer getAttemptCounter() {
        return attemptCounter;
    }

    public Integer[] getCounters() {
        return new Integer[]{cowCounter,bullCounter};

    }


    @Override
    public String toString() {
        return String.format("На %d попытке вы угадали %d символа. Точных совпадений %d",attemptCounter, cowCounter, bullCounter);
    }
}
