package study;

import study.calculator.Calculator;

import java.util.Scanner;

/**
 * @author : JAKE
 * @date : 2022/09/25
 */
public class StringCalculator {


    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        calculator.execute(value);
    }
}