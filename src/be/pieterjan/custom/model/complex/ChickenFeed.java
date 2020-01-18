package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.crops.Carrot;
import be.pieterjan.custom.model.crops.Wheat;

public class ChickenFeed extends Product {
    public ChickenFeed() {
        getIngredients().put(Wheat.class, 2);
        getIngredients().put(Carrot.class, 1);
    }
}
