package gb.oop.homeworks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Класс описывающий рациональные числа, т.е. числа вида a/b
 * numerator - числитель дроби
 * denominator - знаменатель дроби, если попытаться присвоить ему ноль, то значение принудительно будет изменено на 1.
 *
 * Метод valueOf() - возвращает значение в виде десятичной дроби.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatioType implements Comparable {
    private int numerator;
    private int denominator;

    public RatioType(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator==0){
            System.out.printf("Знаменатель не может быть равен нулю!!!%nПоэтому я назначаю ему значение 1");
            denominator = 1;
        }
        this.denominator = denominator;
    }

    public RatioType(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    /**
     * Компаратор для рациональных числе
     * @param ratioType - первое число
     * @param other - второе число
     * @return 0 - если равны<br>1 - если первое больше второго<br>-1 - если первое меньше второго.
     */
    public static int compare(RatioType ratioType, RatioType other) {
        int commonDenominator = ratioType.denominator * other.denominator;
        int thisNumerator = ratioType.numerator*other.denominator;
        int otherNumerator = other.numerator*ratioType.denominator;
        if (other.numerator==ratioType.numerator && other.denominator==ratioType.denominator) {
            return 0;
        } else if (thisNumerator>otherNumerator) {
            return 1;
        } else return -1;
    }

    public void setDenominator(int denominator) {
        if (denominator==0) denominator = 1;
        this.denominator = denominator;
    }

    public double valueOf(){
        return (double)numerator/denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatioType ratioType = (RatioType) o;
        return numerator == ratioType.numerator && denominator == ratioType.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d",numerator,denominator);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Object o) {
        RatioType ratioType = (RatioType) o;
        int commonDenominator = this.denominator * ratioType.denominator;
        int thisNumerator = this.numerator*ratioType.denominator;
        int otherNumerator = ratioType.numerator*this.denominator;
        if (this.numerator==ratioType.numerator && this.denominator==ratioType.denominator) {
            return 0;
        } else if (thisNumerator>otherNumerator) {
            return 1;
        } else return -1;

    }
}
