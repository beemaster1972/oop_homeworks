package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iLogger;
import gb.oop.homeworks.interfaces.iOrder;
import gb.oop.homeworks.interfaces.iProduct;
import gb.oop.homeworks.interfaces.iStore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Класс описывающий склад
 */
@AllArgsConstructor
@Data
public class Warehouse extends AbstractWarehouse {
    // Словарь для хранения товара и его количества
    protected Map<iProduct, Double> products;
    // логгер
    protected iLogger logger;
    // Список для хранения заказов
    protected List<iOrder> orders;
    // Как будем работать с базой данных
    protected iStore store;

    public Warehouse(String name, Map<iProduct, Double> products, iLogger logger, List<iOrder> orders, iStore store) {
        this.name = name;
        this.products = products;
        this.logger = logger;
        this.orders = orders;
        this.store = store;
    }

    /**
     * Метод добавления товара на склад
     * @param product - товар
     * @param amount  - количество
     */
    public void addProduct(iProduct product, Double amount) {
        Double remains = products.put(product, amount);
        if (Objects.isNull(remains)) {
            logger.log(String.format("Товар %s успешно добавлен на склад %s в кол-ве %.3f", product.getName(), name, amount));
        } else if (remains + amount <= product.getMaxQuantity()) {
            products.put(product, remains + amount);
            logger.log(String.format("Кол-во товара %s на складе %s увеличено на %.3f", product.getName(), name, amount));
        } else
            logger.log(String.format("Кол-во товара %s на складе %s может превысить максимально допустимое значение %.3f, поэтому товар не добавлен", product.getName(), name, product.getMaxQuantity()));
    }

    /**
     * Метод для списания товара со склада
     * @param product - товар
     * @param amount  - количество
     */
    public void removeProduct(iProduct product, Double amount) {
        double remains = products.getOrDefault(product, 0.0);
        if (remains - amount >= 0){
            products.put(product, remains - amount);
            logger.log("Товар %s успешно отправлен со склада %s");
        } else {
            logger.log(String.format("Нет достаточного кол-ва товара %s на складе %s для отгрузки", product, name));
        }

    }

    @Override
    public String getName() {
        return name;
    }

    public void addOrder(iOrder order) {
        orders.add(order);
    }
}
