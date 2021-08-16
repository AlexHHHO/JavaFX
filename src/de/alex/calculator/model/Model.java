package de.alex.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Model {

    double result2;

    public double calculation(double firstDigit, double secondDigit, String operator) {

        switch (operator) {
            case "+":
                return firstDigit + secondDigit;
            case "-":
                return firstDigit - secondDigit;
            case "*":
                return firstDigit * secondDigit;
            case "/":
                if (secondDigit == 0) return 0;
                return firstDigit / secondDigit;
        }
        System.out.println("Unknown operator: " + operator);
        return 0;
    }
//        double result2 = 0;
//        switch (operator){
//            case "+":
//                result2 = firstDigit + secondDigit;
//                break;
//            case "-":
//                result2 = firstDigit - secondDigit;
//                break;
//            case "*":
//                result2 = firstDigit * secondDigit;
//                break;
//            case "/":
//                if (secondDigit == 0)return 0;
//                result2 = firstDigit / secondDigit;
//                break;
//            default:
//                System.out.println("Unknown operator: " + operator);
//        }
//        return 0;
//    }

    public double percentCalculation(double firstDigit, double secondDigit, String operator) {
        double result = ((firstDigit / 100) * secondDigit);
        switch (operator){
            case "+":
                return firstDigit + result;
            case "-":
                return firstDigit - result;
            case "*":
                return firstDigit * result;
            case "/":
                if (secondDigit == 0) return 0;
                return firstDigit / result;
        }
        System.out.println("Unknown operator: " + operator);
        return 0;
    }
//    public int rounding(String s){
//        double result1 = new BigDecimal(result2).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
//        int result = (int)result1;
//        return result;
//    }


}

