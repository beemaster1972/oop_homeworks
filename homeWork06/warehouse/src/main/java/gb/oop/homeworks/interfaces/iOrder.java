package gb.oop.homeworks.interfaces;

import gb.oop.homeworks.enums.TypesOfInvoices;
import gb.oop.homeworks.models.Warehouse;

import java.util.Map;

public interface iOrder {

    void processOrder(Warehouse warehouse, iProduct product, double amount, TypesOfInvoices typeInvoice);


}
