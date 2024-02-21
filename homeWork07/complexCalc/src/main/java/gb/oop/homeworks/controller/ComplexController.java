package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.ComplexType;
import gb.oop.homeworks.service.GetChoice;
import gb.oop.homeworks.view.View;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComplexController implements iController {
    private final static String promptComplex = "Введите комплексное число (например: 5+10i): ";
    private final static String promptMenu = "1. Произвести вычисления%n" +
            "0. Выйти из калькулятора%n" +
            "Ваш выбор: ";
    private final static String promptOperation = "Введите операцию: ";
    private static Logger logger;

    public ComplexController() {
    }

    public ComplexController(Logger logger) {
        ComplexController.logger = logger;
    }

    @Override
    public void run(View view) {
        String arg;
        GetChoice getChoice = new GetChoice();
        log(Level.FINE, String.format("Scanner initialized"));
        int menuCommand;
        boolean exit = false;
        while (!exit) {
            menuCommand = getChoice.getIntChoice(promptMenu);
            log(Level.FINE, String.format("User selected %d. menu item", menuCommand));
            switch (menuCommand) {
                case 1:
                    ComplexType firstArg = getChoice.getComplex(promptComplex);
                    log(Level.FINE, String.format("First argument is %s", firstArg));
                    Character op = getChoice.getStrChoice(promptOperation).charAt(0);
                    log(Level.FINE, String.format("Operation is %s", firstArg));
                    ComplexType secondArg = getChoice.getComplex(promptComplex);
                    log(Level.FINE, String.format("Second argument is %s", secondArg));
                    System.out.printf("(%s) %s (%s) = %s%n", firstArg, op, secondArg, view.printCalc(op, firstArg, secondArg));
                    break;
                case 0:
                    exit = true;
                    log(Level.FINE, String.format("Exiting from application"));
                    break;
                default:
                    log(Level.FINE, String.format("An unknown command has been entered"));
                    System.out.println("Неизвестная комманда");
                    break;
            }
        }
        getChoice.close();

        log(Level.FINE, String.format("Сlosing Scanner"));

    }

    private void log(Level level, String message) {
        if (logger == null) return;
        logger.log(level, message);
    }
}
