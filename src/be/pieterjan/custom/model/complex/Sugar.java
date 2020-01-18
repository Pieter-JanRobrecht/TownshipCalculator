package be.pieterjan.custom.model.complex;

import be.pieterjan.custom.model.Product;
import be.pieterjan.custom.model.crops.SugarCane;

public class Sugar extends Product {
    public Sugar() {
        getIngredients().put(SugarCane.class, 1);
    }
}
