package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.crops.Wheat;

public class Bread extends Product {
    public Bread() {
        getIngredients().put(Wheat.class, 2);
        setTime(5);
    }
}
