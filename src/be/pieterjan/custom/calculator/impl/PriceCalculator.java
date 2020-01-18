package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.calculator.Calculator;
import be.pieterjan.custom.model.Crop;
import be.pieterjan.custom.model.Product;

public class PriceCalculator extends Calculator<Integer> {
    public Integer calculate(int amount, Class<? extends Product> productClass)
            throws IllegalAccessException, InstantiationException {
        Integer priceTotal = 0;
        Product product = productClass.newInstance();

        if (Crop.class.isAssignableFrom(productClass)) {
            Crop crop = (Crop) product;

            return crop.getPrice() * amount;
        }

        for (Class<? extends Product> ingredient : product.getIngredients().keySet()) {
            int amountOfIngredient = getAmountOfIngredient(product, ingredient);

            for (int i = 0; i < amountOfIngredient; i++) {
                priceTotal += calculate(amount, ingredient);
            }
        }

        return priceTotal;
    }
}
