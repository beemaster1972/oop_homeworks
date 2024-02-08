package gb.oop.homeworks;

import java.util.regex.Pattern;

public class BinaryCalculator<B> extends Calculator {
    public BinaryCalculator() {
        super();
    }

    public Integer fromBinary(B number) {
        int res = 0;
        String strBin = number.toString();
        if (Pattern.matches("^[01]+$", strBin)) {
            int exponent = 0;
            for (int i = strBin.length() - 1; i >= 0; i--) {
                res += (int) Math.pow(2, exponent++) * Integer.parseInt(String.valueOf(strBin.charAt(i)));

            }
        } else return null;
        return res;

    }

    public String toBinary (B number){
        String res = "";
        Double num = Math.floor(Double.parseDouble(number.toString()));;
        if (num<=0) return null;
        while (num !=0){
            res += num % 2;
            num /= 2;
        }
        return res;

    }
}