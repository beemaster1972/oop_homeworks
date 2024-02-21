package gb.oop.homeworks.model;

/**
 * Класс реализующий умножение комплексных чисел
 */
public class ComplexMultiplication implements iCalculator, iComplexCalculator {
    /**
     * Метод возвращает результат последовательного умножения чисел ComplexType
     *
     * @param args любое количество аргументов ComplexType не меньше двух.
     * @return ComplexType | null
     */
    @Override
    public ComplexType calculate(ComplexType... args) {
        if (args.length < 2) return null;
        int realPart = 1, oldRealPart=1, imaginaryPart = 0;
        for (ComplexType complexType : args) {
            if (complexType==null) return null;
            realPart = realPart * complexType.getRealPart() + (complexType.getImaginaryPart() * imaginaryPart) * -1;
            imaginaryPart = oldRealPart * complexType.getImaginaryPart() + complexType.getRealPart() * imaginaryPart;
            oldRealPart = realPart;
        }
        return new ComplexType(realPart, imaginaryPart);
    }
}
