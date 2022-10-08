package study.calculator;

import java.security.InvalidParameterException;

/**
 * @author : JAKE
 * @date : 2022/09/25
 */
public class Calculator {

    public int execute(String str) {

        if (isNotSuitableCalculator(str)) {
            throw new InvalidParameterException("계산식에 적합하지 않습니다.");
        }

        return getResultValue(str);
    }

    public int getResultValue(String str) {

        String[] values = str.split(" ");

        int result = 0;
        String operator = "";

        for (int i=0; i<values.length; i++) {

            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }

            if (i % 2 == 1) {
                operator = values[i];
                continue;
            }

            result =  calculate(result, operator, Integer.parseInt(values[i]));
        }

        return result;
    }

    public int calculate(int a, String operator, int b) {
        switch (operator) {
            case "+" :
                return add(a, b);
            case "-" :
                return minus(a, b);
            case "*" :
                return multiply(a,b);
            case "/" :
                return divide(a,b);
            default:
                return 0;
        }
    }

    public boolean isNotSuitableCalculator(String str) {

        if (str.length() == 0) {
            return true;
        }

        String[] values = str.split(" ");

        for (int i=0; i<values.length; i++) {

            if (i % 2 == 0) {
                if (!isNumeric(values[i])) {
                    return true;
                }
                continue;
            }

            if (!isOperator(values[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean isOperator(String operator) {

        if (operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")) {
            return true;
        }

        return false;
    }

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException ne) {
            return false;
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
