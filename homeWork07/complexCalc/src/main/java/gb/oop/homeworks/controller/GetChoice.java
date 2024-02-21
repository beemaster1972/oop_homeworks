package gb.oop.homeworks.controller;

import gb.oop.homeworks.model.ComplexType;

import java.lang.annotation.Inherited;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetChoice {
    /**
     * Получение выбора от пользователя
     *
     * @param prompt приглашение
     * @return Integer | null
     */
    static Scanner scanner = new Scanner(System.in);
    public Integer getIntChoice(String prompt) {
        System.out.printf(prompt);
        String choice = scanner.next();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        }
        return null;
    }

    public String getStrChoice(String prompt){
        System.out.printf(prompt);
        String choice = scanner.next();
        return choice;
    }

    public ComplexType getComplex(String prompt){
        String arg;
        arg = getStrChoice(prompt);
        if (!arg.matches("\\d+[+-]\\d+i|\\d+")){
            return null;
        }
        Pattern pattern = Pattern.compile("(\\d+)([+-]?)(\\d+)([i])");
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.find()) return null;
        int realPart = Integer.parseInt(matcher.group(1));
        int imaginaryPart = matcher.group(2).equals("-") ? Integer.parseInt(matcher.group(3))*-1:Integer.parseInt(matcher.group(3));
        return new ComplexType(realPart,imaginaryPart);
    }

    public void close(){
        scanner.close();
    }


}
