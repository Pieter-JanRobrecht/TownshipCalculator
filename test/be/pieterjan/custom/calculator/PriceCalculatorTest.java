package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.crops.*;
import be.pieterjan.custom.model.complex.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {
    PriceCalculator calculator = new PriceCalculator();

    @Test
    void testPriceWheat() {
        int actual = calculator.calculate(1, Wheat.class);

        assertEquals(0, actual);
    }

    @Test
    void testPriceCarrots() {
        int actual = calculator.calculate(3, Carrot.class);

        assertEquals(6, actual);
    }

    @Test
    void testPriceBread() {
        int actual = calculator.calculate(1, Bread.class);

        assertEquals(0, actual);
    }

    @Test
    void testPriceChickenFeed() {
        int actual = calculator.calculate(2, ChickenFeed.class);

        assertEquals(4, actual);
    }

    @Test
    void testPriceEgg() {
        int actual = calculator.calculate(1, Egg.class);

        assertEquals(2, actual);
    }

    @Test
    void testPriceBagel() {
        int actual = calculator.calculate(1, Bagel.class);

        assertEquals(9, actual);
    }
}