package gb.oop.homeworks.interfaces;

import gb.oop.homeworks.enums.TypesOfInvoices;
import gb.oop.homeworks.models.AbstractWarehouse;

public interface iOrder {

    void processOrder(AbstractWarehouse warehouse, iProduct product, double amount, TypesOfInvoices typeInvoice);


}
