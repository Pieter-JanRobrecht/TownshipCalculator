package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.crops.Wheat;

public class Bagel extends Product {
    public Bagel() {
        getIngredients().put(Wheat.class, 2);
        getIngredients().put(Sugar.class, 1);
        getIngredients().put(Egg.class, 3);
    }
}
