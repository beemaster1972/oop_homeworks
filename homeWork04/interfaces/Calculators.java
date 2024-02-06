package gb.oop.homeworks.interfaces;

public interface Calculators<N> {
    N sum();
    N mult();
    N div();
    N fromBinary();

    String toBinary(N number);
}
