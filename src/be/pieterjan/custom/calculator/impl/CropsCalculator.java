package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.calculator.Calculator;
import be.pieterjan.custom.model.Crop;
import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;

public class CropsCalculator implements Calculator<IngredientList> {

    @Override
    public IngredientList calculate(int amount, Class<? extends Product> productClass) throws IllegalAccessException, InstantiationException {
        Product product = productClass.newInstance();
        IngredientList resultList = new IngredientList();

        for (Class<? extends Product> ingredientClass : product.getIngredients().keySet()) {
            int amountOfIngredient = getAmountOfIngredient(product, ingredientClass);

            if (Crop.class.isAssignableFrom(ingredientClass)) {
                addCropsToResult(amount, resultList, ingredientClass, amountOfIngredient);
            } else {
                addComplexToResult(amount, resultList, ingredientClass, amountOfIngredient);
            }
        }

        return resultList;
    }

    private void addComplexToResult(int amount, IngredientList resultList, Class<? extends Product> ingredientClass, int amountOfIngredients)
            throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < amountOfIngredients; i++) {
            resultList.putAll(calculate(amount, ingredientClass));
        }
    }

    private void addCropsToResult(int amount, IngredientList resultList, Class<? extends Product> ingredientClass, int amountOfIngredients) {
        int help = amountOfIngredients * amount;

        if (resultList.containsKey(ingredientClass)) {
            help += resultList.get(ingredientClass);
        }

        resultList.put(ingredientClass, help);
    }
}
