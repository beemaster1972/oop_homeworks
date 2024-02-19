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

@Data
public class LoggingWarehouse extends Warehouse {

//    protected Map<iProduct, Double> products;
    protected iLogger logger;
//    protected List<iOrder> orders;
//    protected iStore store;

    public LoggingWarehouse(String name, Map<iProduct, Double> products, iLogger logger, List<iOrder> orders, iStore store) {
        super(name,products,orders,store);

        this.logger = logger;
    }

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
