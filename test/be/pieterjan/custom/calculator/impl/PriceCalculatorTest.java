package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.model.crops.*;
import be.pieterjan.custom.model.complex.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {
    private PriceCalculator calculator = new PriceCalculator();

    @Test
    void testPriceWheat() throws Exception {
        int actual = calculator.calculate(1, Wheat.class);

        assertEquals(0, actual);
    }

    @Test
    void testPriceCarrots() throws Exception {
        int actual = calculator.calculate(3, Carrot.class);

        assertEquals(6, actual);
    }

    @Test
    void testPriceBread() throws Exception {
        int actual = calculator.calculate(1, Bread.class);

        assertEquals(0, actual);
    }

    @Test
    void testPriceChickenFeed() throws Exception {
        int actual = calculator.calculate(2, ChickenFeed.class);

        assertEquals(4, actual);
    }

    @Test
    void testPriceEgg() throws Exception {
        int actual = calculator.calculate(1, Egg.class);

        assertEquals(2, actual);
    }

    @Test
    void testPriceBagel() throws Exception {
        int actual = calculator.calculate(1, Bagel.class);

        assertEquals(9, actual);
    }
}