package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iLogger;
import gb.oop.homeworks.interfaces.iStore;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс для сохранения базы в тектсовый файл
 */
@AllArgsConstructor
public class TxtStore implements iStore {
    iLogger logger;
    String path;
    @Override
    public void connect(String path) {
        if (!path.isEmpty()) {
            this.path = path;
        }
        logger.log(String.format("Соединились с файлом %s%n",path));
    }

    @Override
    public void save(Warehouse warehouse) {
        logger.log(String.format("Записали данные по складу %s в файл %s",warehouse.getName(),path));

    }

    @Override
    public Warehouse load() {
        Warehouse result = new Warehouse(path, new HashMap<>(), logger, new ArrayList<>(), this);
        logger.log(String.format("Загрузили склад %s из файла %s", result.getName(),path));
        return result;
    }
}
