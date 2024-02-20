package gb.oop.homeworks.model;

/**
 * Класс реализующий суммирование комплексных чисел
 */
public class ComplexAddition implements iCalculator, iComplexCalculator {
    /**
     * Последовательное суммирование комплексных чисел
     *
     * @param args любое количество аргументов типа ComplexType не меньше двух
     * @return ComplexType | null
     */
    @Override
    public ComplexType calculate(ComplexType... args) {
        int realPart = 0, imaginaryPart = 0;
        for (ComplexType complexType : args) {
            realPart += complexType.getRealPart();
            imaginaryPart += complexType.getImaginaryPart();
        }
        return new ComplexType(realPart, imaginaryPart);
    }


}
