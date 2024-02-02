package gb.oop.homeworks;

public interface Game {
    /**
     * Метод начинающий игру
     * @param sizeWord длина загадываемого слова
     * @param maxTry количество попыток
     * @param conditions условия генерации слова
     */
    void start(Integer sizeWord, Integer maxTry, Conditions conditions);

    /**
     * Метод заканчивающий игру с результатом ПРОИГРЫШ
     */
    void stop();

    /**
     * Метод перезапускающий текущую игру
     */
    void restart();

    /**
     * Метод проверки ответа игрока
     * @param value введенный ответ игрока
     * @return класс Answer
     */
    Answer inputValue(String value);

    /**
     * Метод возвращающий текущий статус игры
     * @return
     */
    GameStatus getGameStatus();
}
