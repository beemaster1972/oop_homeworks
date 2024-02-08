package gb.oop.homeworks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Класс реализующий структуру Учебной Группы
 */
public class StudyGroup implements Education{
    private Teacher teacher;
    private List<Student> studentsList;

}
