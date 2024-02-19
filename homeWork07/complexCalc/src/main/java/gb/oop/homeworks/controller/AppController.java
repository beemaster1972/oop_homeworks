package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.BinaryCalculator;
import gb.oop.homeworks.model.iCalculator;
import gb.oop.homeworks.model.ListCalculator;
import gb.oop.homeworks.view.BinaryView;
import gb.oop.homeworks.view.ListView;
import gb.oop.homeworks.view.View;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private ListController listController;

    private BinaryController binaryController;

    public AppController(ListController listController, BinaryController binaryController) {
        this.listController = listController;
        this.binaryController = binaryController;
    }

    public AppController() {
        listController = new ListController();
        binaryController = new BinaryController();
    }

    public void runCalc() {
        listController.runList();
        binaryController.runBinary();



    }

}
