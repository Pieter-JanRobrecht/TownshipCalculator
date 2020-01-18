package be.pieterjan.custom;

import be.pieterjan.custom.calculator.impl.TownshipCalculator;
import be.pieterjan.custom.model.complex.Bagel;


public class CalculatorProgram {
    public static void main(String[] args) throws Exception {
        System.out.println(new TownshipCalculator().calculate(34, Bagel.class));
    }
}
