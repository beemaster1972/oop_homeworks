package gb.oop.homeworks.model;

public class ComplexCalculatorNull implements iCalculator, iComplexCalculator{
    @Override
    public ComplexType calculate(ComplexType... args) {
        return null;
    }
}
