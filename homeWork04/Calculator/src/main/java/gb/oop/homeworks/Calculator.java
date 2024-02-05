/*
3)	Написать класс калькулятор, принимающий List целочисленных значений,
возвращающий сумму элементов коллекции (метод sum)
 */
package gb.oop.homeworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calculator<N extends Number> {

    private List<N> numbers;

    public Double sum() {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}

