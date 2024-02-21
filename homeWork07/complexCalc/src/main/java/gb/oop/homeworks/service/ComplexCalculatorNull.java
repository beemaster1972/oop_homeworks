package gb.oop.homeworks.service;

import gb.oop.homeworks.model.ComplexType;

public class ComplexCalculatorNull implements iCalculator, iComplexCalculator{
    @Override
    public ComplexType calculate(ComplexType... args) {
        return null;
    }
}
