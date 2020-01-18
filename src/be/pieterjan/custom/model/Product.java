package be.pieterjan.custom.model;

public class Product {
    private IngredientList ingredients;

    public IngredientList getIngredients() {
        if (ingredients == null) {
            ingredients = new IngredientList();
        }

        return ingredients;
    }

    public void setIngredients(IngredientList ingredients) {
        this.ingredients = ingredients;
    }
}
