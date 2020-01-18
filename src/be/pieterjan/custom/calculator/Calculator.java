package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;


public abstract class Calculator<R> {
    public abstract R calculate(int amount, Class<? extends Product> productClass);

    protected int getAmountOfIngredient(Product product, Class<? extends Product> productClass) {
        IngredientList ingredients = product.getIngredients();

        if (ingredients.containsKey(productClass)) {
            return product.getIngredients().get(productClass);
        }

        return 0;
    }
}
