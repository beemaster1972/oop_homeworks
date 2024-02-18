package gb.oop.homeworks;

public class ConsoleLogger implements iLogger{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
