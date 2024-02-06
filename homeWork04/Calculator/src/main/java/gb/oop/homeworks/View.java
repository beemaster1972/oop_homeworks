package gb.oop.homeworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class View<C extends Calculator> {
    private C calc;
    public String printCalc(String func, String parameter, String result){
        return String.format("%s(%s) = %s",func, parameter,result);
    }
}
