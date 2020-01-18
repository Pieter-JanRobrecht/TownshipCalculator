package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.*;
import be.pieterjan.custom.model.complex.Bagel;
import be.pieterjan.custom.model.complex.Bread;
import be.pieterjan.custom.model.complex.ChickenFeed;
import be.pieterjan.custom.model.complex.Egg;
import be.pieterjan.custom.model.crops.Carrot;
import be.pieterjan.custom.model.crops.SugarCane;
import be.pieterjan.custom.model.crops.Wheat;
import org.junit.jupiter.api.Test;

import static be.pieterjan.custom.calculator.CropsCalculator.calculate;
import static org.junit.jupiter.api.Assertions.*;

class CropsCalculatorTest {

    @Test
    void testCalculateWheat() {
        IngredientList actual = calculate(2, Wheat.class);

        assertEquals(2, actual.get(Wheat.class));
    }

    @Test
    void testCalculateCarrot() {
        IngredientList actual = calculate(3, Carrot.class);

        assertEquals(3, actual.get(Carrot.class));
    }

    @Test
    void testCalculateBread() {
        IngredientList actual = calculate(2, Bread.class);

        assertEquals(4, actual.get(Wheat.class));
        assertNull(actual.get(Carrot.class));
    }

    @Test
    void testCalculateChickenFeed() {
        IngredientList actual = calculate(1, ChickenFeed.class);

        assertEquals(2, actual.get(Wheat.class));
        assertEquals(1, actual.get(Carrot.class));
    }

    @Test
    void testCalculateEgg() {
        IngredientList actual = calculate(2, Egg.class);

        assertEquals(4, actual.get(Wheat.class));
        assertEquals(2, actual.get(Carrot.class));
    }

    @Test
    void testCalculateBagel() {
        IngredientList actual = calculate(1, Bagel.class);

        assertEquals(8, actual.get(Wheat.class));
        assertEquals(3, actual.get(Carrot.class));
        assertEquals(1, actual.get(SugarCane.class));
    }
}