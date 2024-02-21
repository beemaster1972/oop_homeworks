package gb.oop.homeworks.controller;

import gb.oop.homeworks.service.GetChoice;
import gb.oop.homeworks.view.ComplexView;
import gb.oop.homeworks.view.LoggingComplexView;
import gb.oop.homeworks.view.View;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppController {
    private static Logger calcLogger = Logger.getLogger(LoggingComplexView.class.getName());
    private iController controller;
    private View view;
    private final static String calcMenu = "Выберите калькулятор:%n" +
            "1. Комплексный калькулятор%n" +
            "2. Комплексный калькулятор с логированием%n"+
            "Ваш выбор: ";


    public AppController() {
        try {
            LogManager.getLogManager().readConfiguration(
                    AppController.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        Integer choice = null;
        while (choice == null && controller == null) {
            choice = new GetChoice().getIntChoice(calcMenu);
            controller = switch (choice) {
                case 1 -> new ComplexController();
                case 2 -> new ComplexController(calcLogger);
                default -> null;
            };
            view = switch (choice) {
                case 1 -> new ComplexView();
                case 2 -> new LoggingComplexView(calcLogger);
                default -> null;
            };
        }
    }

    public void run() {
        controller.run(view);


    }

}
