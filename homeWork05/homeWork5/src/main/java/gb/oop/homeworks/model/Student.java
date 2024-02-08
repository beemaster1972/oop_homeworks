package gb.oop.homeworks.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Класс Студента расширяющий класс User
 */
@Setter
@Getter
public class Student extends User{
    private Integer idStudent;

    public Student() {
        this("Balda","29.02.2004");
    }

    public Student(String fullName, String dateOfBirth) {
        super(fullName, dateOfBirth);
        this.idStudent = null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                " "+ super.toString();
    }
}
