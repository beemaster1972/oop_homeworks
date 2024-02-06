package gb.oop.homeworks;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        List<Integer> intList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        BinaryCalculator<String> strBin = new BinaryCalculator<>();
        String str = "101";
        System.out.printf("Dec(%s) = %d%n",str, strBin.fromBinary(str));
        View<BinaryCalculator> viewBinary = new View<>();
        BinaryCalculator<Long> longBin = new BinaryCalculator<>();
        str = "111";
        System.out.printf("Dec(%s) = %d%n", Long.parseLong(str,10),longBin.fromBinary(Long.parseLong(str,10)));
        BinaryCalculator<Double> doubleBin = new BinaryCalculator<>();
        System.out.printf("Dec(%f) = %d%n", 101.0,doubleBin.fromBinary(101.0));
        for (int i = 5; i > 0; i--) {
            intList.add(i);
            doubleList.add((double) i);
        }
        System.out.printf("Сумма целых = %.2f%n", calc.sum(intList));
        System.out.printf("Сумма double = %.2f%n", calc.sum(doubleList));
        System.out.printf("Умножение int = %.2f%n", calc.mult(intList));
        System.out.printf("Умножение  double = %.2f%n", calc.mult(doubleList));
        System.out.printf("Деление int = %f%n", calc.div(intList));
        System.out.printf("Деление double = %f%n", calc.div(doubleList));
    }
}