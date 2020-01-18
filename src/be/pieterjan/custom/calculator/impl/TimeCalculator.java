package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.calculator.Calculator;
import be.pieterjan.custom.model.Crop;
import be.pieterjan.custom.model.Product;

import java.util.HashSet;
import java.util.Set;

public class TimeCalculator extends Calculator<Integer> {

    @Override
    public Integer calculate(int amount, Class<? extends Product> productClass) {
        try {
            Set<Class<? extends Product>> productSet = createSet(productClass);

            return productSet.stream()
                    .map(clazz -> {
                        try {
                            return clazz.newInstance();
                        } catch (Exception e) {
                            throw new IllegalArgumentException("bitch pls");
                        }
                    })
                    .map(Product::getTime)
                    .mapToInt(Integer::intValue)
                    .sum();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Should have passed a valid class");
        }
    }

    private Set<Class<? extends Product>> createSet(Class<? extends Product> productClass) throws InstantiationException, IllegalAccessException {
        Product product = productClass.newInstance();
        Set<Class<? extends Product>> productSet = new HashSet<>();

        productSet.add(productClass);
        for (Class<? extends Product> ingredient : product.getIngredients().keySet()) {
            productSet.add(ingredient);

            if (!Crop.class.isAssignableFrom(ingredient)) {
                productSet.addAll(createSet(ingredient));
            }
        }
        return productSet;
    }
}
