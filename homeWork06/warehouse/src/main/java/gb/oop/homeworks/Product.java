package gb.oop.homeworks;

import java.util.Objects;

public class Product implements iProduct{
    protected String name;

    public Product(String name, int quantity, int price, int maxQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.maxQuantity = maxQuantity;
    }

    protected int quantity;
    protected int price;
    protected int maxQuantity;
    @Override
    public boolean decreaseQuantity(int amount) {
        if (quantity - amount < 0 || quantity - amount > maxQuantity){
            return false;
        }
        quantity -= amount;
        return true;
    }

    @Override
    public boolean IncreaseQuntity(int amount) {
        if (quantity+amount>maxQuantity || quantity+amount<0){
            return false;
        }
        quantity += amount;
        return true;
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
