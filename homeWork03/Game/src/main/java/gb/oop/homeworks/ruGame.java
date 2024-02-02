package gb.oop.homeworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий игру с кирилицей
 */
public class RuGame extends AbstractGame{
    @Override
    public List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 'а'; i <= 'я'; i++) {
            result.add(String.valueOf((char) i));

        }
        result.add("ё");
        return result;
    }

    @Override
    public Integer getCharListSize() {
        return 33;
    }

    @Override
    public String getTypeGame() {
        return "'Игра с кирилицей'";
    }
}
