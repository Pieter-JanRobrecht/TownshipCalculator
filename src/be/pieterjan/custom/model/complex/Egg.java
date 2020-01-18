package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.complex.ChickenFeed;

public class Egg extends Product {
    public Egg() {
        getIngredients().put(ChickenFeed.class, 1);
    }
}
