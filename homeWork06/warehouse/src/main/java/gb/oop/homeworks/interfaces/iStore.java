package gb.oop.homeworks.interfaces;

import gb.oop.homeworks.models.Warehouse;

public interface iStore {
    void connect(String path);
    void save(Warehouse warehouse);
    Warehouse load();
}
