package gb.oop.homeworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class Calculator {
    public Double sum(List<? extends Number> numbers){
        double res =0;
        for (Number number : numbers) {
            res += number.doubleValue();
        }
        return res;
    }

    public Double mult(List<? extends Number> numbers){
        double res = 1;
        for (Number number : numbers) {
            res *= number.doubleValue();
        }
        return res;
    }

    public Double div(List<? extends Number> numbers){
        double res = numbers.get(0).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).doubleValue()!=0)
                res /= numbers.get(i).doubleValue();
        }
        return res;
    }
}
