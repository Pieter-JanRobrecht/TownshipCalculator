package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.model.complex.*;
import be.pieterjan.custom.model.crops.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeCalculatorTest {

    private TimeCalculator calculator = new TimeCalculator();

    @Test
    void testTimeWheat() {
        int actual = calculator.calculate(1, Wheat.class);

        assertEquals(2, actual);
    }

    @Test
    void testTimeMultipleWheat() {
        int actual = calculator.calculate(3, Wheat.class);

        assertEquals(2, actual);
    }

    @Test
    void testTimeBread() {
        int actual = calculator.calculate(1, Bread.class);

        assertEquals(7, actual);
    }

    @Test
    void testTimeChickenFeed() {
        int actual = calculator.calculate(2, ChickenFeed.class);

        assertEquals(22, actual);
    }

    @Test
    void testTimeBagel() {
        int actual = calculator.calculate(1, Bagel.class);

        assertEquals(152, actual);
    }
}