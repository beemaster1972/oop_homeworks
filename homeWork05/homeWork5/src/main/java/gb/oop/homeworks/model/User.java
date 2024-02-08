package gb.oop.homeworks.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс прародитель всех сущностей
 */
@Getter
@Setter
public abstract class User implements Education {

    private String fullName;
    private String dateOfBirth;

    public User() {
    }

    public User(String fullName, String dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
