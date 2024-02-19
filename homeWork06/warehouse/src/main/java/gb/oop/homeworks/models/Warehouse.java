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

@AllArgsConstructor
@Data
public class Warehouse extends AbstractWarehouse {

    protected Map<iProduct, Double> products;
    protected List<iOrder> orders;
    protected iStore store;

    public Warehouse(String name, Map<iProduct, Double> products, List<iOrder> orders, iStore store) {
        this.name = name;
        this.products = products;
        this.orders = orders;
        this.store = store;
    }
    public Warehouse(){
        super();
    }

    public void addProduct(iProduct product, Double amount) {
        Double remains = products.put(product, amount);
        if (remains + amount <= product.getMaxQuantity()) {
            products.put(product, remains + amount);
        }
    }

    public void removeProduct(iProduct product, Double amount) {
        double remains = products.getOrDefault(product, 0.0);
        if (remains - amount >= 0) {
            products.put(product, remains - amount);
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
