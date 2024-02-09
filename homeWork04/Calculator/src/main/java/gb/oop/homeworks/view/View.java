package gb.oop.homeworks.view;



/**
 * Интерфейс классов View для классов Calculator
 */
public interface View<C>{

    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     * <C> - дженерик Calculator
     * @param funcIndex - целое число:<br>
     *                  0 - sum Сумма элементов списка<br>
     *                  1 - product умножение элементов списка<br>
     *                  2 - div деление элементов списка<br>
     *                  3 - fromBinary конвертер из двоичного в десятичный<br>
     *                  4 - toBinary конвертер из десятичного в двоичный<br>
     * @param parameter - List<? extends Number> | Number | String - параметр для вычисления
     * @return строка с результатом
     */
    String printCalc(int funcIndex, C calc, Object parameter);
}
