package gb.oop.homeworks;


import java.util.ArrayList;
import java.util.List;

public class NumeralGame extends AbstractGame{
    @Override
    public List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    @Override
    public Integer getCharListSize() {
        return 10;
    }
}
