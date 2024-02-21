package gb.oop.homeworks.view;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingComplexView extends ComplexView{
    private static Logger logger;
    public LoggingComplexView(){}
    public LoggingComplexView(Logger logger){
        LoggingComplexView.logger = logger;
    }
    @Override
    public String printCalc(char operation, Object firstArg, Object secondArg) {
        String result = super.printCalc(operation, firstArg, secondArg);
        logger.log(Level.INFO,String.format("(%s) %s (%s) = %s%n", firstArg,operation,secondArg,result));

        return result;
    }
}
