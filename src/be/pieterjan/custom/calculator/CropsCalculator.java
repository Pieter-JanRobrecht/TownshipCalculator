package be.pieterjan.custom.calculator;

import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.Crop;

public class CropsCalculator extends Calculator<IngredientList> {

    public IngredientList calculate(int amount, Class<? extends Product> productClass) {
        try {
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
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Should have given an accepted class");
        }
    }

    private void addComplexToResult(int amount, IngredientList resultList, Class<? extends Product> ingredientClass, int amountOfIngredients) {
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
