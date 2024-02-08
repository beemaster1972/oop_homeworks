package gb.oop.homeworks.service;

import gb.oop.homeworks.model.Student;
import gb.oop.homeworks.model.StudyGroup;
import gb.oop.homeworks.model.Teacher;
import lombok.Getter;

import java.util.List;

/**
 * Класс Модели Учебной Группы
 */
@Getter
public class StudyGroupService implements DataService<StudyGroup> {

    StudyGroup studyGroup;

    @Override
    public void create(StudyGroup user) {
        studyGroup = user;

    }

    public void setTeacher(TeacherService teacherService, int teacherId){
        studyGroup.setTeacher(teacherService.read(teacherId));
    }

    public void setStudentsList(StudentService studentService){
        studyGroup.setStudentsList(studentService.getStudentsList());
    }

    @Override
    public StudyGroup read(int id) {
        return null;
    }

    @Override
    public int getTotalNumber() {
        return studyGroup.getStudentsList().size();
    }
}
