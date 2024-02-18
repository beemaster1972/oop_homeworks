package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iProduct;

public abstract class AbstractWarehouse {

    protected String name;
    abstract void addProduct(iProduct product, Double amount);
    abstract void removeProduct(iProduct product, Double amount);
    abstract String getName();
}
