package gb.oop.homeworks;

import java.util.List;
import java.util.Random;

/** Класс прародитель всех игр типа Быки и коровы */
public abstract class AbstractGame implements Game {
    private String word; //Загаданное слово
    private Integer attemptCounter; //Текущее количество попыток
    private Integer maxAttempts; //Начальное количество попыток
    private Integer wordSize; //Длина загаданного слова
    private Conditions currentCondition; //Текущие условия генерации слова
    private GameStatus status = GameStatus.INIT; //Статус игры
    private HistoryGame historyGame; //История текущей игры
//    private Integer charListSize; //Размер используемого "алфавита" для генерации слова

    /**
     * Метод генерации загаданного слова
      * @param sizeWord Целое число, длина загаданного слова
     * @param conditions Условия генерации (только уникальные символы или повторяющиеся)
     * @return Строку - загаданное слово
     */
    public String generateWord(Integer sizeWord, Conditions conditions) {
        StringBuilder result = new StringBuilder();
        List<String> charList = generateCharList();
//        charListSize = charList.size();
        Random rand = new Random();
        String randomSymbol = charList.get(rand.nextInt(charList.size()));
        for (int i = 0; i < sizeWord; i++) {
            switch (conditions) {
                case UNIQUE_SYMBOLS:
                    while (result.lastIndexOf(randomSymbol) > -1) {
                        randomSymbol = charList.get(rand.nextInt(charList.size()));
                    }
                    break;
            }
            result.append(randomSymbol);
        }
        return result.toString();
    }

    public HistoryGame getHistoryGame() {
        return historyGame;
    }

    /**
     * Метод генерации "алфавита"
     * Метод имплементируется в классах реализующих конкретный тип игры
     * @return Список символов
     */
    public abstract List<String> generateCharList();

    /**
     * Метод начала игры
     * @param sizeWord размер загаданного слова
     * @param attemptCounter количество попыток
     * @param conditions условия генерации загаданного слова
     * Если текущий статус RESTART то будет использовано текущее слово,
     * переинициализируются количество попыток и история игры
     */
    @Override
    public void start(Integer sizeWord, Integer attemptCounter, Conditions conditions) {
        if (!status.equals(GameStatus.RESTART)) {
            word = generateWord(sizeWord, conditions);
            maxAttempts = attemptCounter;
            wordSize = sizeWord;
            currentCondition = conditions;
        }
        status = GameStatus.START;
        this.attemptCounter = attemptCounter;
        historyGame = new HistoryGame();
    }

    @Override
    public void stop() {
        status = GameStatus.INIT;
    }

    @Override
    public void restart() {
        status = GameStatus.RESTART;
        start(wordSize, maxAttempts, currentCondition);
    }

    @Override
    public void exit() {
        status = GameStatus.EXIT;
    }

    /**
     * Метод проверки введенного ответа игрока
     * @param value ответ игрока
     * @return класс Answer
     */
    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START))
            throw new RuntimeException("Игра не в активном состоянии");
        int cowCount = 0;
        int bullCount = 0;
        if (!value.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == value.charAt(i)) {
                    bullCount++;
                    cowCount++;
                } else if (word.contains(String.valueOf(value.charAt(i))))
                    cowCount++;
            }
        }
        --attemptCounter;
        if (bullCount == word.length()) {
            status = GameStatus.WIN;
        } else if (attemptCounter == 0) {
            status = GameStatus.LOSE;
        }
        Answer result = new Answer(attemptCounter, cowCount, bullCount);
        historyGame.addTurn(result, value);
        return result;
    }

    public abstract Integer getCharListSize();
    public abstract String getTypeGame();
    public String getHiddenWord(){
        return word;
    }
    public Integer getAttemptLeft(){
        return attemptCounter;
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }
}
