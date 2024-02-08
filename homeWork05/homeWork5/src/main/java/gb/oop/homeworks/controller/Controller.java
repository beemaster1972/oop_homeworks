package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.Student;
import gb.oop.homeworks.model.StudyGroup;
import gb.oop.homeworks.model.Teacher;
import gb.oop.homeworks.model.User;
import gb.oop.homeworks.service.StudentService;
import gb.oop.homeworks.service.StudyGroupService;
import gb.oop.homeworks.service.TeacherService;
import gb.oop.homeworks.view.StudentView;
import gb.oop.homeworks.view.TeacherView;
import gb.oop.homeworks.view.View;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Controller {
    private StudyGroupService service;
    private View view;
    private String separator = "=======================================================";

    //    public Controller(){
//        this.service = service;
//        this.view = view;
//    }

    /**
     * Метод заполнения списка студентов
     *
     * @return Экземпляр класса StudentService
     */
    private StudentService setStudents() {
        StudentService studentService = new StudentService();
        Student stud1 = new Student("Ivan", "01.01.2000");
        studentService.create(stud1);
        studentService.create(new Student("Boris", "29.02.1992"));
        studentService.create(new Student());
        return studentService;
    }

    /**
     * Метод создания нового преподавателя
     *
     * @return Экземпляр класса TeacherService
     */
    private TeacherService setTeacher() {
        Teacher teacher1 = new Teacher("Roman Voronovsky", "01.01.1980");
        TeacherService teacherService = new TeacherService();
        teacherService.create(teacher1);
        return teacherService;
    }

    /**
     * Метод возвращающий id преподавателя текущей Учебной Группы
     *
     * @return Целое значение id преподавателя
     */
    private int getIdTeacher() {
        return service.getStudyGroup().getTeacher().getIdTeacher();
    }

    /**
     * Метод возвращающий список id студентов из текущей Учебной Группы
     *
     * @return Список целых чисел
     */
    private ArrayList<Integer> getStudentsId() {
        ArrayList<Integer> idList = new ArrayList<>();
        for (Student student : service.getStudyGroup().getStudentsList()) {
            idList.add(student.getIdStudent());

        }
        return idList;
    }

    /**
     * Метод запуска приложения
     */
    public void run() {
        Random rand = new Random();
        StudentService studentsService = setStudents();
        TeacherService teacherService = setTeacher();
        service = new StudyGroupService();
        service.create(new StudyGroup());
        service.setTeacher(teacherService, 0);
        service.setStudentsList(studentsService);
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        System.out.println(separator);
        System.out.println("Преподаватель группы:");
        teacherView.print(teacherService.read(getIdTeacher()));
        System.out.println("Состав группы:");
        System.out.println(separator);
        for (Integer i : getStudentsId()) {
            studentView.print(studentsService.read(i));
        }
        System.out.println(separator);
    }
}
