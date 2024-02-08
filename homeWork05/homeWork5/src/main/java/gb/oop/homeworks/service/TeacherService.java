package gb.oop.homeworks.service;

import gb.oop.homeworks.model.Teacher;

/**
 * Класс Модели Преподавателя
 */
public class TeacherService implements DataService<Teacher>{
    private static int teacherIndex;
    static {
        teacherIndex = 0;
    }

    //TODO реализовать хранение списка преподавателей
    private Teacher teacher;
    @Override
    public void create(Teacher user) {
        user.setIdTeacher(teacherIndex++);
        teacher = user;

    }

    @Override
    public Teacher read(int id) {
        //TODO реализовать поиск по id преподавателя
        return teacher;
    }

    @Override
    public int getTotalNumber() {
        //TODO возможно нужно реализовать возврат общего количество преподавателей
        return 1;
    }
}
