package be.pieterjan.custom.model.crops;

import be.pieterjan.custom.model.Crop;

public class Carrot extends Crop {
    public Carrot() {
        getIngredients().put(Carrot.class, 1);
        setPrice(2);
        setTime(10);
    }
}
