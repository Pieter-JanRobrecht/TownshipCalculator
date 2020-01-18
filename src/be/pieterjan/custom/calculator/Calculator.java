package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;


public  interface Calculator<R> {
    R calculate(int amount, Class<? extends Product> productClass)
            throws InstantiationException, IllegalAccessException;

    default int getAmountOfIngredient(Product product, Class<? extends Product> productClass) {
        IngredientList ingredients = product.getIngredients();

        if (ingredients.containsKey(productClass)) {
            return product.getIngredients().get(productClass);
        }

        return 0;
    }
}
