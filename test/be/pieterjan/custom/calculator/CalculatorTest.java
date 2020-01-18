package be.pieterjan.custom.calculator;

import be.pieterjan.custom.calculator.impl.PriceCalculator;
import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.crops.Carrot;
import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.crops.Wheat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Product testProduct;
    private Calculator<Integer> calculator = new PriceCalculator();

    @BeforeEach
    void setUp() {
        testProduct = new Product();
        IngredientList ingredient = new IngredientList();

        ingredient.put(Wheat.class, 1);
        testProduct.setIngredients(ingredient);
    }

    @Test
    void testGetAmountPresent() {
        int amount = calculator.getAmountOfIngredient(testProduct, Wheat.class);

        assertEquals(1, amount);
    }

    @Test
    void testGetAmountNotPresent() {
        int amount = calculator.getAmountOfIngredient(testProduct, Carrot.class);

        assertEquals(0, amount);
    }
}