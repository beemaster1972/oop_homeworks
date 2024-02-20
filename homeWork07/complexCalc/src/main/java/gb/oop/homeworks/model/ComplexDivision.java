package gb.oop.homeworks.model;

/**
 * Класс реализующий деление комплексных чисел
 */
public class ComplexDivision implements iCalculator, iComplexCalculator {
    /**
     * Деление комплексных чисел
     *
     * @param args Только два числа типа ComplexType, если второй аргумент будет равен нулю, то вернется null.
     * @return ComplexType | null результат деления
     */

    @Override
    public ComplexType calculate(ComplexType... args) {
        if (args.length < 2) {
            System.out.println("Для операции деления можно передавать только два аргумента!!!");
            return null;
        }
        if (args[1].equals(new ComplexType(0, 0))) {
            System.out.println("В нашем калькуляторе запрещено делить на ноль!!!");
            return null;
        }
        ComplexType conjugateNumber = new ComplexType(args[1].getRealPart(),
                args[1].getImaginaryPart() * -1);
        ComplexType numerator = new ComplexMultiplication().calculate(args[0], conjugateNumber);
        int denominator = args[1].getRealPart() * args[1].getRealPart() +
                args[1].getImaginaryPart() * args[1].getImaginaryPart();
        return new ComplexType(numerator.getRealPart() / denominator,
                numerator.getImaginaryPart() / denominator);
    }
}
