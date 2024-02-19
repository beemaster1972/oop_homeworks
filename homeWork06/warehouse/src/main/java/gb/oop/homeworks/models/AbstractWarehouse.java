package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iOrder;
import gb.oop.homeworks.interfaces.iProduct;

import java.util.Map;

public abstract class AbstractWarehouse {

    public AbstractWarehouse(){}

    protected String name;
    abstract void addProduct(iProduct product, Double amount);
    abstract void removeProduct(iProduct product, Double amount);
    public abstract String getName();

    public abstract Map<iProduct, Double> getProducts();
    public abstract void addOrder(iOrder order);
}
