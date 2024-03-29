package gb.oop.homeworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий тип игры с латинским алфавитом
 */
public class EnGame extends AbstractGame{
    @Override
    public List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            result.add(String.valueOf((char)i));

        }
        return result;
    }

    @Override
    public Integer getCharListSize() {
        return 26;
    }

    @Override
    public String getTypeGame() {
        return "'Игра с латинским алфавитом'";
    }
}
