package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.ComplexType;
import gb.oop.homeworks.view.ComplexView;
import gb.oop.homeworks.view.View;

public class ComplexController implements iController {
    private final static String promptComplex = "Введите комплексное число (например: 5+10i): ";
    private final static String promptMenu = "1. Произвести вычисления%n"+
            "0. Выйти из калькулятора%n"+
            "Ваш выбор: ";
    private final static String promptOperation = "Введите операцию: ";

    @Override
    public void run(View view) {
        String arg;
        GetChoice getChoice = new GetChoice();
        int menuCommand;
        boolean exit = false;
        while (!exit){
            menuCommand = getChoice.getIntChoice(promptMenu);
            switch (menuCommand){
                case 1:
                    ComplexType firstArg = getChoice.getComplex(promptComplex);
                    Character op = getChoice.getStrChoice(promptOperation).charAt(0);
                    ComplexType secondArg = getChoice.getComplex(promptComplex);
                    System.out.printf("%s %s %s = %s%n",firstArg,op,secondArg,view.printCalc(op, firstArg, secondArg));
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Неизвестная комманда");
                    break;
            }
        }
        getChoice.close();

    }
}
