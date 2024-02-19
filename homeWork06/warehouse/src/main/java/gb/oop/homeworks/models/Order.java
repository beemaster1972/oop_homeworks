package gb.oop.homeworks.models;

import gb.oop.homeworks.enums.TypesOfInvoices;
import gb.oop.homeworks.interfaces.iOrder;
import gb.oop.homeworks.interfaces.iProduct;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс обрабатывающий заказ на складе
 */
@Data
public class Order implements iOrder {

    private String numberInvoice;

    private TypesOfInvoices typeInvoice;

    private Warehouse warehouse;

    private iProduct product;

    private Double amount;
    static int number;
    static {
        number = 0;
    }

    /**
     * Обработчик заказа
     * @param warehouse   - склад
     * @param product     - товар
     * @param amount      - количество
     * @param typeInvoice - тип накладной - Приходная | Расходная
     */
    @Override
    public void processOrder(Warehouse warehouse,iProduct product, double amount, TypesOfInvoices typeInvoice) {
        numberInvoice = warehouse.getName() + String.valueOf(++number);
        this.warehouse = warehouse;
        this.product = product;
        this.amount = amount;
        this.typeInvoice = typeInvoice;
        switch (typeInvoice){
            case INVOICE:
                warehouse.addProduct(product,amount);
                break;
            case WAYBILL:
                warehouse.removeProduct(product,amount);
                break;
            default:
                warehouse.logger.log(String.format("Неизвестный тип накладной %s", typeInvoice.getDescription()));
                break;
        }
        warehouse.addOrder(this);
    }
}
