package be.pieterjan.custom.model;

import java.util.HashMap;
import java.util.Map;

public class IngredientList extends HashMap<Class<? extends Product>, Integer> {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IngredientList {\n");

        this.forEach((key, value) -> {
            builder.append(key.getSimpleName());
            builder.append(": ");
            builder.append(value);
            builder.append("\n");
        });

        builder.append("}");
        return builder.toString();
    }

    @Override
    public void putAll(Map<? extends Class<? extends Product>, ? extends Integer> map) {
        for (Class<? extends Product> key : map.keySet()) {
            if (this.containsKey(key)) {
                this.put(key, map.get(key) + this.get(key));
            } else {
                this.put(key, map.get(key));
            }
        }
    }
}
