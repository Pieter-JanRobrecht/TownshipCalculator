package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.model.crops.*;
import be.pieterjan.custom.model.complex.*;
import be.pieterjan.custom.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TownshipCalculatorTest {
    TownshipCalculator calculator = new TownshipCalculator();

    @Test
    void testWheat() throws Exception {
        CalculationResult result = calculator.calculate(1, Wheat.class);

        assertEquals(0, result.getTotalCost());
        assertEquals(2, result.getTotalTime());
        assertEquals(1, result.getIngredientList().get(Wheat.class));
    }

    @Test
    void testBagel() throws Exception {
        CalculationResult result = calculator.calculate(1, Bagel.class);

        assertEquals(9, result.getTotalCost());
        assertEquals(152, result.getTotalTime());
        assertEquals(8, result.getIngredientList().get(Wheat.class));
        assertEquals(3, result.getIngredientList().get(Carrot.class));
        assertEquals(1, result.getIngredientList().get(SugarCane.class));
    }
}