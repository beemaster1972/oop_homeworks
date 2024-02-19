package gb.oop.homeworks.model;

public class ComplexCalculator implements iCalculator, iComplexCalculator{
    @Override
    public ComplexType sum(ComplexType... args) {
        int realPart = 0, imaginaryPart=0;
        for (ComplexType complexType:args){
            realPart += complexType.getRealPart();
            imaginaryPart += complexType.getImaginaryPart();
        }
        return new ComplexType(realPart,imaginaryPart);
    }

    @Override
    public ComplexType prod(ComplexType... args) {
        int realPart = 1, imaginaryPart=1;
        for (ComplexType complexType:args) {
            realPart = realPart*complexType.getRealPart() + complexType.getImaginaryPart()*imaginaryPart;
            imaginaryPart = realPart*complexType.getImaginaryPart()+ complexType.getRealPart()*imaginaryPart;
        }
        return new ComplexType(realPart,imaginaryPart);
    }

    @Override
    public ComplexType divide(ComplexType... args) {
        if (args.length!=2) {
            System.out.println("Для операции деления можно передавать только два аргумента!!!");
            return null;
        }
        if (args[1].equals(new ComplexType(0,0))){
            System.out.println("В нашем калькуляторе запрещено делить на ноль!!!");
            return null;
        }
        ComplexType conjugateNumber = new ComplexType(args[1].getRealPart(),args[1].getImaginaryPart()*-1);
        ComplexType numerator = prod(args[0],conjugateNumber);
        int denominator = args[1].getRealPart()*args[1].getRealPart() + args[1].getImaginaryPart()*args[1].getImaginaryPart();
        return new ComplexType(numerator.getRealPart()/denominator, numerator.getImaginaryPart()/denominator);
    }
}
