package gb.oop.homeworks.models;

import gb.oop.homeworks.interfaces.iProduct;
import lombok.Data;

import java.util.Objects;

@Data

/**
 * Класс описывающий товар
 */
public class Product implements iProduct {
    protected String name;
    protected int price;
    protected Double maxQuantity;

    public Product(String name, int price, double maxQuantity) {
        this.name = name;
        this.price = price;
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", maxQuantity=" + maxQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && maxQuantity == product.maxQuantity && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, maxQuantity);
    }
}
