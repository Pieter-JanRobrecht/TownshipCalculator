package be.pieterjan.custom.model;

public class Product {
    private IngredientList ingredients;
    private Integer time;

    public IngredientList getIngredients() {
        if (ingredients == null) {
            ingredients = new IngredientList();
        }

        return ingredients;
    }

    public void setIngredients(IngredientList ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
