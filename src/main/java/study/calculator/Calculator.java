package study.calculator;

import java.security.InvalidParameterException;

/**
 * @author : JAKE
 * @date : 2022/09/25
 */
public class Calculator {

    public void execute(String str) {

        if (isNotSuitableCalculator(str)) {
            throw new InvalidParameterException("계산식에 적합하지 않습니다.");
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
}
