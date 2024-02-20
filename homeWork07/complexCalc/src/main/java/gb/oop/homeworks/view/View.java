package gb.oop.homeworks.view;



/**
 * Интерфейс классов View для классов Calculator
 */
public interface View{

    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     *
     * @param operation - символ [+,*,/]:<br>
     * @param firstArg - первый аргумент для вычисления
     * @param secondArg - второй аргумент для вычисления
     * @return строка с результатом вычислений
     */
    String printCalc(char operation, Object firstArg, Object secondArg);
}
