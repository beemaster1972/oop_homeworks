package gb.oop.homeworks.view;

import gb.oop.homeworks.model.Student;

public class StudentView implements View<Student> {

    public void print(Student student){
        System.out.println(student);
    }

}
