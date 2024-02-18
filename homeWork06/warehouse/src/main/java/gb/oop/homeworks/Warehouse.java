package gb.oop.homeworks;

import java.util.List;
import java.util.Set;

public class Warehouse {

    protected String name;
    protected Set<iProduct> productList;
    protected iLogger logger;

    public void addProduct(iProduct product){
        if (productList.add(product)) {
            logger.log(String.format("Товар %s успешно добавлен на склад %s", product, name));
        } else {
            logger.log(String.format("Товар %s уже есть на складе %s", product, name));
        }
    }

    public void removeProduct(iProduct product){
        if (productList.contains(product)){
            productList.remove(product);
            logger.log("Товар %s успешно удален со склада %s");
        } else{
            logger.log(String.format("Товара %s нет на складе %s", product, name));
        }
    }

    public void increaseQuantityProduct(iProduct product, int amount){
        if (product.IncreaseQuntity(amount)){
            logger.log(String.format("На складе %s кол-во товара %s увеличено на %d", name, product, amount));
        } else {
            logger.log(String.format("Не возможно увеличить количество товара %s на %d", product, amount));
        }
    }
}
