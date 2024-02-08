package gb.oop.homeworks.service;

import gb.oop.homeworks.model.Education;
import gb.oop.homeworks.model.User;

/**
 * Интерфейс для всех Моделей
 * @param <U> U - класс описывающий структуру (Студент, Преподаватель, Учебная Группа)
 */

public interface DataService<U extends Education> {
    void create(U user);
    U read(int id);
    int getTotalNumber();

}
