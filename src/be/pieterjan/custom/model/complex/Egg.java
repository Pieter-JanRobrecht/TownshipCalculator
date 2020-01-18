package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;

public class Egg extends Product {
    public Egg() {
        getIngredients().put(ChickenFeed.class, 1);
        setTime(60);
    }
}
