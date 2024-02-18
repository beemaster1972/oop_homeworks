package gb.oop.homeworks.controller;

import gb.oop.homeworks.enums.TypesOfInvoices;
import gb.oop.homeworks.interfaces.View;
import gb.oop.homeworks.interfaces.iOrder;
import gb.oop.homeworks.interfaces.iProduct;
import gb.oop.homeworks.interfaces.iStore;
import gb.oop.homeworks.models.*;
import gb.oop.homeworks.view.WarehouseView;

public class Controller {

    Warehouse model;
    View viewWarehouse;

    public void runApp(){
        iProduct nails = new Product("Гвозди дюймовка", 10, 1_000_000);
        iStore txtStore = new TxtStore(new ConsoleLogger(),"Склад гвоздей");
        model = txtStore.load();
        viewWarehouse = new WarehouseView(model);
        iOrder invoice = new Order();
        invoice.processOrder(model, nails, 100_000, TypesOfInvoices.INVOICE);
        viewWarehouse.printValue();
        iOrder wayBill = new Order();
        // Расходная накладная с ошибкой - слишком большое количество
        wayBill.processOrder(model,nails,1_000_000,TypesOfInvoices.WAYBILL);
        // Расходная накладная уменьшающая кол-во на 50 тыс
        wayBill.processOrder(model,nails,50_000,TypesOfInvoices.WAYBILL);
        viewWarehouse.printValue();
        invoice.processOrder(model,new Product("Гвозди 120", 12, 1_000_000), 200_000,TypesOfInvoices.INVOICE);
        viewWarehouse.printValue();


    }
}
