package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.BinaryCalculator;
import gb.oop.homeworks.model.iBinaryCalculator;
import gb.oop.homeworks.view.BinaryView;
import gb.oop.homeworks.view.View;

public class BinaryController {
    public BinaryController() {
        model = getBinaryModel();
        viewBinary = new BinaryView();
    }

    public BinaryController(iBinaryCalculator model, View<BinaryCalculator> viewBinary) {
        this.model = model;
        this.viewBinary = viewBinary;
    }

    private iBinaryCalculator model;

    private View<BinaryCalculator> viewBinary;

    private BinaryCalculator getBinaryModel(){
        return new BinaryCalculator();
    }

    public void runBinary(){
        String separator = "========================================================================";
        System.out.println(separator);
        System.out.println("Из строки в десятичное");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, model.getNumber()));
        System.out.println("Из Long в десятичное");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, Long.valueOf("101010101011101101")));
        System.out.println("Из Double в десятичное");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, (double) 101010101101101.000));
        System.out.println("Из Long в десятичное с ошибкой");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, Long.valueOf("201010101011101101")));
        System.out.println(separator);
        System.out.println("Из int в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, (int) 7));
        System.out.println("Из Long в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, Long.valueOf("100")));
        System.out.println("Из Double в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, (double) 7.000));
        System.out.println("Из Строки в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, "101010101011101101"));

    }
}
