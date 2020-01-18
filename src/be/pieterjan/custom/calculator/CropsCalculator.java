package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.Crop;

import static be.pieterjan.custom.calculator.CalculatorUtils.getAmountForClass;

public class CropsCalculator {

    public static IngredientList calculate(int amount, Class<? extends Product> productClass) {
        try {
            Product product = productClass.newInstance();
            IngredientList calculated = new IngredientList();

            for (Class<? extends Product> ingredientClass : product.getIngredients().keySet()) {
                int amountOfIngredients = getAmountForClass(product, ingredientClass);

                if (Crop.class.isAssignableFrom(ingredientClass)) {
                    addCropsToResult(amount, calculated, ingredientClass, amountOfIngredients);
                } else {
                    addComplexToResult(amount, calculated, ingredientClass, amountOfIngredients);
                }
            }

            return calculated;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Should have given an accepted class");
        }
    }

    private static void addComplexToResult(int amount, IngredientList calculated, Class<? extends Product> ingredientClass, int amountOfIngredients) {
        for (int i = 0; i < amountOfIngredients; i++) {
            calculated.putAll(calculate(amount, ingredientClass));
        }
    }

    private static void addCropsToResult(int amount, IngredientList calculated, Class<? extends Product> ingredientClass, int amountOfIngredients) {
        int help = amountOfIngredients * amount;

        if (calculated.containsKey(ingredientClass)) {
            help += calculated.get(ingredientClass);
        }

        calculated.put(ingredientClass, help);
    }
}
