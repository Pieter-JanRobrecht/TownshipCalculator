package be.pieterjan.custom.calculator.impl;

import be.pieterjan.custom.calculator.Calculator;
import be.pieterjan.custom.model.Crop;
import be.pieterjan.custom.model.Product;

import java.util.HashSet;
import java.util.Set;

public class TimeCalculator implements Calculator<Integer> {

    @Override
    public Integer calculate(int amount, Class<? extends Product> productClass) throws InstantiationException, IllegalAccessException {
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
