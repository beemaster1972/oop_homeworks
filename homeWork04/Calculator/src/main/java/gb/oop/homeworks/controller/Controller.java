package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.BinaryCalculator;
import gb.oop.homeworks.model.Calculator;
import gb.oop.homeworks.model.ListCalculator;
import gb.oop.homeworks.view.BinaryView;
import gb.oop.homeworks.view.ListView;
import gb.oop.homeworks.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Calculator model;
    private View<ListCalculator> viewList;
    private View<BinaryCalculator> viewBinary;

    private ListCalculator<Integer> getIntListModel() {
        ListCalculator<Integer> result = new ListCalculator<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            intList.add(i);
        }
        result.setNumbers(intList);
        return result;
    }

    private ListCalculator<Double> getDoubleListModel(){
        ListCalculator<Double> result = new ListCalculator<>();
        List<Double> doubleList = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            doubleList.add(Double.valueOf(i));
        }
        result.setNumbers(doubleList);
        return result;
    }

    private BinaryCalculator getBinaryModel(){
        return new BinaryCalculator();
    }

    public void runCalc() {
        model = getIntListModel();
        viewList = new ListView();
        String separator = "========================================================================";
        System.out.println(separator);
        System.out.println("Целые числа");
        System.out.println(viewList.printCalc(0, (ListCalculator) model, model.getNumbers()));
        System.out.println(viewList.printCalc(1, (ListCalculator) model, model.getNumbers()));
        System.out.println(viewList.printCalc(2, (ListCalculator) model, model.getNumbers()));
        System.out.println(separator);
        model = getDoubleListModel();
        System.out.println("Double числа");
        System.out.println(viewList.printCalc(0, (ListCalculator) model, model.getNumbers()));
        System.out.println(viewList.printCalc(1, (ListCalculator) model, model.getNumbers()));
        System.out.println(viewList.printCalc(2, (ListCalculator) model, model.getNumbers()));
        System.out.println(separator);
        model = getBinaryModel();
        viewBinary = new BinaryView();
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
