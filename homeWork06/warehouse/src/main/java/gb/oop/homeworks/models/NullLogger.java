package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iLogger;

/**
 * Класс-заглушка ничего не делающий
 */
public class NullLogger implements iLogger {
    @Override
    public void log(String message) {

    }
}
