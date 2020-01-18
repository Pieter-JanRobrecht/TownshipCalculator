package be.pieterjan.custom;

import be.pieterjan.custom.calculator.CropsCalculator;
import be.pieterjan.custom.model.complex.Bagel;


public class CalculatorProgram {
    public static void main(String[] args) {
        System.out.println(new CropsCalculator().calculate(34, Bagel.class));
    }
}
