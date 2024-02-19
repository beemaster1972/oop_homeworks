package gb.oop.homeworks.interfaces;

import gb.oop.homeworks.models.AbstractWarehouse;
import gb.oop.homeworks.models.LoggingWarehouse;

public interface iStore {
    void connect(String path);
    void save(AbstractWarehouse warehouse);
    AbstractWarehouse load();
}
