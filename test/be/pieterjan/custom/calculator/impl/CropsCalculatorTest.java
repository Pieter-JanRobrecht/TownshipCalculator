package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.model.*;
import be.pieterjan.custom.model.complex.*;
import be.pieterjan.custom.model.crops.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CropsCalculatorTest {
    private CropsCalculator calculator = new CropsCalculator();

    @Test
    void testCalculateWheat() {
        IngredientList actual = calculator.calculate(2, Wheat.class);

        assertEquals(2, actual.get(Wheat.class));
    }

    @Test
    void testCalculateCarrot() {
        IngredientList actual = calculator.calculate(3, Carrot.class);

        assertEquals(3, actual.get(Carrot.class));
    }

    @Test
    void testCalculateBread() {
        IngredientList actual = calculator.calculate(2, Bread.class);

        assertEquals(4, actual.get(Wheat.class));
        assertNull(actual.get(Carrot.class));
    }

    @Test
    void testCalculateChickenFeed() {
        IngredientList actual = calculator.calculate(1, ChickenFeed.class);

        assertEquals(2, actual.get(Wheat.class));
        assertEquals(1, actual.get(Carrot.class));
    }

    @Test
    void testCalculateEgg() {
        IngredientList actual = calculator.calculate(2, Egg.class);

        assertEquals(4, actual.get(Wheat.class));
        assertEquals(2, actual.get(Carrot.class));
    }

    @Test
    void testCalculateBagel() {
        IngredientList actual = calculator.calculate(1, Bagel.class);

        assertEquals(8, actual.get(Wheat.class));
        assertEquals(3, actual.get(Carrot.class));
        assertEquals(1, actual.get(SugarCane.class));
    }
}