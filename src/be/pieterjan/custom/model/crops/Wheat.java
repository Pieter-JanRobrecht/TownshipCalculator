package be.pieterjan.custom.model.crops;

import be.pieterjan.custom.model.Crop;

public class Wheat extends Crop {
    public Wheat() {
        getIngredients().put(Wheat.class, 1);
        setPrice(0);
        setTime(2);
    }
}
