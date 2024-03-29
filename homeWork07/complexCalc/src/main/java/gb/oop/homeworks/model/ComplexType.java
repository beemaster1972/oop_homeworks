package gb.oop.homeworks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Класс реализующий комплексные числа
 * RatioType realPart - действительная часть
 * RatioType imaginaryPart - мнимая часть
 */

@Data
public class ComplexType {
    /** Действительная часть*/
    private int realPart;
    /** Мнимая часть*/
    private int imaginaryPart;
    public ComplexType(int realPart,int imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    public ComplexType(int realPart){
        this.realPart = realPart;
        this.imaginaryPart = 0;
    }
    public ComplexType(){
        realPart = 0;
        imaginaryPart = 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexType that = (ComplexType) o;
        return realPart == that.realPart && imaginaryPart == that.imaginaryPart ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        String sign = switch (Integer.compare(imaginaryPart,0)) {
            case -1 -> "%d - %di";
            case 1 -> "%d + %di";
            case 0 -> "%d";
            default -> "null";
        };
        return String.format(sign, realPart, Math.abs(imaginaryPart));

    }
}
