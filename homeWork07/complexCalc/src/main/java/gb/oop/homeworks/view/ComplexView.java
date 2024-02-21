package gb.oop.homeworks.view;

import gb.oop.homeworks.model.*;

import java.util.HashMap;
import java.util.Map;

public class ComplexView implements View{
    static Map<Character, iComplexCalculator> operations;

    static {
        operations = new HashMap<>();
        operations.put('+', new ComplexAddition());
        operations.put('*', new ComplexMultiplication());
        operations.put('/', new ComplexDivision());
    }

    @Override
    public String printCalc(char operation, Object firstArg, Object secondArg) {
        iComplexCalculator calc = operations.getOrDefault(operation,new ComplexCalculatorNull());
        ComplexType result = calc.calculate((ComplexType) firstArg,(ComplexType) secondArg);
        return (result==null)?null:result.toString();
    }
}
