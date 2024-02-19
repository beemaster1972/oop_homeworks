package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iLogger;

/**
 * Класс выводящий лог в консоль
 */
public class ConsoleLogger implements iLogger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
