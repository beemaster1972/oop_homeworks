package gb.oop.homeworks.controller;

import gb.oop.homeworks.service.GetChoice;
import gb.oop.homeworks.view.ComplexView;
import gb.oop.homeworks.view.View;

public class AppController {
    private iController controller;
    private View view;
    private final static String calcMenu = "Выберите калькулятор:%n" +
            "1. Комплексный калькулятор%n" +
            "Ваш выбор: ";


    public AppController() {
        Integer choice = null;
        while (choice == null && controller == null) {
            choice = new GetChoice().getIntChoice(calcMenu);
            controller = switch (choice) {
                case 1 -> new ComplexController();
                default -> null;
            };
            view = switch (choice) {
                case 1 -> new ComplexView();
                default -> null;
            };
        }
    }

    public void run() {
        controller.run(view);


    }

}
