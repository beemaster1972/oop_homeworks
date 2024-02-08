package gb.oop.homeworks.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс Преподавателя расширяющий класс User
 */
@Setter
@Getter
public class Teacher extends User{
    private Integer idTeacher;

    public Teacher() {
        this("Ivan Ivanych", "01.01.1970");
    }

    public Teacher(String fullName, String dateOfBirth) {
        super(fullName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                " "+super.toString();
    }
}
