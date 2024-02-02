package gb.oop.homeworks;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс реализующий хранение и вывод истории текущей игры
 */
public class HistoryGame {
    private Map<Answer, String> turn;


    public HistoryGame() {
        turn = new LinkedHashMap<>();
    }

    public void addTurn(Answer answer, String value){
        turn.put(answer, value);
    }

    /**
     * Метод выводящий всю историю текущй игры
     */
    public void showHistory(){
        for (Answer answer:turn.keySet()){
            Integer attempt = answer.getAttemptCounter();
            Integer[] counters = answer.getCounters();
            System.out.printf("На %d ходу вы ввели слово '%s' и угадали %d символов при %d полных совпадениях%n",
                    attempt+1,
                    turn.get(answer),
                    counters[0],counters[1]);
        }
    }

}
