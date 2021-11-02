package ru.gb.lesson4;

public class Buttons {

    private double digitResult;

    public Buttons() {
    }

    public String setPlusResult(String num1, String num2) {

        int plusResult = Integer.parseInt(num1) + Integer.parseInt(num2);
        return Integer.toString(plusResult);
    }

    public String setMinusResult(String num1, String num2) {
        int minusResult = Integer.parseInt(num1) - Integer.parseInt(num2);
        return String.valueOf(minusResult);
    }

    public String setDigitResult(String num1, String num2) {
        try {
            this.digitResult = Double.parseDouble(num1) / Double.parseDouble(num2);
        } catch (ArithmeticException e) {
            e.getStackTrace();
        }
        return String.valueOf(digitResult);
    }

    public String setMultiplyResult(String num1, String num2) {
        int multiplyResult = Integer.parseInt(num1) * Integer.parseInt(num2);
        return String.valueOf(multiplyResult);
    }
}