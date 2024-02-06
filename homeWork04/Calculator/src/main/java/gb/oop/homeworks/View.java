package gb.oop.homeworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class View<C extends Calculator> {
    private C calc;
    public String printCalc(int funcIndex, C calc){
        String funcName ="", parameter="",result="";
        switch (funcIndex){
            case 0:
                funcName = "sum";

                break;
        }

        return String.format("%s(%s) = %s",func, parameter,result);
    }
}
