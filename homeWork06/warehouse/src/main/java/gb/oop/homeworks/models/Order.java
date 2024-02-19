package gb.oop.homeworks.models;

import gb.oop.homeworks.enums.TypesOfInvoices;
import gb.oop.homeworks.interfaces.iOrder;
import gb.oop.homeworks.interfaces.iProduct;
import lombok.Data;

@Data
public class Order implements iOrder {

    private String numberInvoice;

    private TypesOfInvoices typeInvoice;

    private AbstractWarehouse warehouse;

    private iProduct product;

    private Double amount;
    static int number;
    static {
        number = 0;
    }

    @Override
    public void processOrder(AbstractWarehouse warehouse, iProduct product, double amount, TypesOfInvoices typeInvoice) {
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
                System.out.printf(String.format("Неизвестный тип накладной %s", typeInvoice.getDescription()));
                break;
        }
        warehouse.addOrder(this);
    }
}
