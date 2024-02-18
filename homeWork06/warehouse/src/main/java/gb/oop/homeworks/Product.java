package gb.oop.homeworks;

public class Product implements iProduct{
    protected String name;
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
}
