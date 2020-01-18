package be.pieterjan.custom;

import be.pieterjan.custom.model.complex.Bagel;

import static be.pieterjan.custom.calculator.CropsCalculator.calculate;

public class CalculatorProgram {
    public static void main(String[] args) {
        System.out.println(calculate(34, Bagel.class));
    }
}
