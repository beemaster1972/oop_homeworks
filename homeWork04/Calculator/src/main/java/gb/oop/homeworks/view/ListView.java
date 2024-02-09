package gb.oop.homeworks.view;

import gb.oop.homeworks.model.ListCalculator;

import java.util.List;

/**
 * Класс View для класса ListCalculator
 */
public class ListView implements View<ListCalculator>{

    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     * @param funcIndex - целое число:
     *                  0 - sum Сумма элементов списка
     *                  1 - product умножение элементов списка
     *                  2 - div деление элементов списка
     * @param parameter - List<? extends Number> - параметр для вычисления
     * @return строка с результатом
     */
    @Override
    public String printCalc(int funcIndex, ListCalculator calc,Object parameter){

        String funcName ;
        Double result ;
        switch (funcIndex){
            case 0:
                funcName = "sum";
                result = calc.sum((List<? extends Number>) parameter);
                break;
            case 1:
                funcName = "product";
                result = calc.product((List<? extends Number>) parameter);
                break;
            case 2:
                funcName = "div";
                result = calc.div((List<? extends Number>) parameter);
                break;
            default:
                return null;
        }

        return String.format("%s(%s) = %s",funcName, parameter.toString(), result.toString());
    }

}
