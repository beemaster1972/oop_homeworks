package gb.oop.homeworks;

public interface Game {
    void start(Integer sizeWord, Integer maxTry, Conditions conditions);
    void stop();
    void restart();
    Answer inputValue(String value);
    GameStatus getGameStatus();
}
