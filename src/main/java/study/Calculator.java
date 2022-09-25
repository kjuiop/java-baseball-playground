package study;

import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author : JAKE
 * @date : 2022/09/25
 */
public class Calculator {

    public static void execute(String str) {

        if (isNotSuitableCalculator(str)) {
            throw new InvalidParameterException("계산식에 적합하지 않습니다.");
        }
    }

    public static boolean isNotSuitableCalculator(String str) {

        if (str.length() == 0) {
            return false;
        }

        String[] values = str.split(" ");

        for (int i=0; i<values.length; i++) {

            if (i % 2 == 0) {
                if (!isNumeric(values[i])) {
                    return false;
                }
                continue;
            }

            if (!isOperator(values[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isOperator(String operator) {

        if (operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")) {
            return true;
        }

        return false;
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException ne) {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        execute(value);
    }
}