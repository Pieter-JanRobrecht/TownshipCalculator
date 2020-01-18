package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.calculator.Calculator;
import be.pieterjan.custom.model.CalculationResult;
import be.pieterjan.custom.model.IngredientList;
import be.pieterjan.custom.model.Product;

public class TownshipCalculator extends Calculator<CalculationResult> {

    Calculator<IngredientList> cropsCalculator = new CropsCalculator();
    Calculator<Integer> timeCalculator = new TimeCalculator();
    Calculator<Integer> priceCalculator = new PriceCalculator();

    @Override
    public CalculationResult calculate(int amount, Class<? extends Product> productClass)
            throws IllegalAccessException, InstantiationException {
        CalculationResult result = new CalculationResult();

        result.setIngredientList(cropsCalculator.calculate(amount, productClass));
        result.setTotalTime(timeCalculator.calculate(amount, productClass));
        result.setTotalCost(priceCalculator.calculate(amount, productClass));

        return result;
    }
}
