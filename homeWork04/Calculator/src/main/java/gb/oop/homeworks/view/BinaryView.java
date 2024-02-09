package gb.oop.homeworks.view;

import gb.oop.homeworks.model.BinaryCalculator;

import java.util.List;

public class BinaryView implements View<BinaryCalculator> {
    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     * <C> - дженерик Calculator
     *
     * @param funcIndex - целое число:
     *                  3 - fromBinary конвертер из двоичного в десятичный
     *                  4 - toBinary конвертер из десятичного в двоичный
     * @param calc      - экземпляр бинарного калькулятора
     * @param parameter - Number | String - параметр для вычисления
     * @return строка с результатом
     */
    @Override
    public String printCalc(int funcIndex, BinaryCalculator calc, Object parameter) {

        String funcName ;
        String result ;
        switch (funcIndex){
            case 3:
                funcName = "BinToDec";
                try {
                    result = calc.fromBinary(parameter).toString();
                }
                catch (Exception e){
                    return String.format("Не верное двоичное представление %s%n",parameter.toString());
                }
                break;
            case 4:
                funcName = "NumToBin";
                try{
                    result = calc.toBinary(parameter);
                }
                catch (Exception e){
                    return String.format("Не возможно конвертировать %s в двоичное представление",parameter);
                }
                break;
            default:
                return String.format("Не известный параметр %s",funcIndex);
        }

        return String.format("%s(%s) = %s",funcName, parameter.toString(), result);
    }
}