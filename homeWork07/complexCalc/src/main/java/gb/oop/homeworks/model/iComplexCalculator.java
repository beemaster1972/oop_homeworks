package gb.oop.homeworks.model;

public interface iComplexCalculator {
    ComplexType sum(ComplexType ... args);
    ComplexType prod(ComplexType ... args);
    ComplexType divide(ComplexType ... args);
}
