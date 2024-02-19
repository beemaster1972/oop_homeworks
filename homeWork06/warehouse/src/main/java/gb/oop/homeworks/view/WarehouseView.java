package gb.oop.homeworks.view;

import gb.oop.homeworks.interfaces.View;
import gb.oop.homeworks.interfaces.iProduct;
import gb.oop.homeworks.models.AbstractWarehouse;
import gb.oop.homeworks.models.LoggingWarehouse;
import lombok.AllArgsConstructor;

import java.util.AbstractCollection;
import java.util.Map;

@AllArgsConstructor
public class WarehouseView implements View {
    private AbstractWarehouse warehouse;

    @Override
    public void printValue() {
        System.out.printf("%s%n", warehouse.getName());
        System.out.println(separator);
        System.out.println("Товары на складе");
        System.out.println(separator);
        System.out.println("Наименование  | Цена | Остаток | Стоимость");
        System.out.println(separator);

        Map<iProduct, Double> products = warehouse.getProducts();
        double total = 0.0;
        for (iProduct product : products.keySet()) {
            double remains = products.get(product);
            if (Double.compare(remains, 0.0) == 0) continue;
            System.out.printf("%s | %d | %,.3f | %,.2f|%n", product.getName(), product.getPrice(), remains, remains * product.getPrice());
            total += remains * product.getPrice();
        }
        System.out.println(separator);
        System.out.printf("Итого стоимость товаров на складе: %,.2f%n",total);
    }
}
