package gb.oop.homeworks;

import gb.oop.homeworks.interfaces.Calculators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor

public class BinaryCalculator<B> implements Calculators {
    @Override
    public B sum() {
        return null;
    }

    @Override
    public B mult() {
        return null;
    }

    @Override
    public B div() {
        return null;
    }

    @Override
    public B fromBinary() {
        return null;
    }

    @Override
    public String toBinary(Object number) {
        return null;
    }
}
