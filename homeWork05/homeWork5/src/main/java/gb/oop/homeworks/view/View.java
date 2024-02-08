package gb.oop.homeworks.view;

import gb.oop.homeworks.model.User;

public interface View<U extends User> {
    void print(U user);
}
