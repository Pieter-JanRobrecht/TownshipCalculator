package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;

public class CalculatorUtils {
    public static int getAmountForClass(Product product, Class<? extends Product> productClass) {
        IngredientList ingredients = product.getIngredients();

        if (ingredients.containsKey(productClass)) {
            return product.getIngredients().get(productClass);
        }

        return 0;
    }
}
