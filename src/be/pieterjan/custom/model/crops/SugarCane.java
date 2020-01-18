package be.pieterjan.custom.model.crops;

import be.pieterjan.custom.model.Crop;

public class SugarCane extends Crop {
    public SugarCane() {
        getIngredients().put(SugarCane.class, 1);
        setPrice(20);
    }
}
