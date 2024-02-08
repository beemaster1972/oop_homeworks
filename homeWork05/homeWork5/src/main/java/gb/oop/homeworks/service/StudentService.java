package gb.oop.homeworks.service;

import gb.oop.homeworks.model.Student;
import gb.oop.homeworks.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
/**
 * Класс реализующий Модель Студента
 */
public class StudentService implements DataService<Student> {

    List<Student> studentsList;
    private static int studentIndex;

    static {
        studentIndex = 0;
    }

    public StudentService(){ studentsList = new ArrayList<>();}

    public StudentService(List<Student> studentsList){
        this.studentsList = studentsList;
    }
    @Override
    public int getTotalNumber() {
        return studentsList.size();
    }

    @Override
    public void create(Student user) {
        user.setIdStudent(studentIndex++);
        studentsList.add(user);
    }

    @Override
    public Student read(int id) {
        for (Student user : studentsList) {
            if (user.getIdStudent().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
