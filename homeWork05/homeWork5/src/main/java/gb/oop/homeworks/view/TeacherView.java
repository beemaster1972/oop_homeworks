package gb.oop.homeworks.view;

import gb.oop.homeworks.model.Teacher;

public class TeacherView implements View<Teacher>{
    @Override
    public void print(Teacher user) {
        System.out.println(user);
    }
}
