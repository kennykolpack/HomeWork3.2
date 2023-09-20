package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private static long idCounter = 1;
    private final Map<Long, Ingredient> ingredients = new LinkedHashMap<>();

    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(idCounter, ingredient);
        return idCounter++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null) {
         return ingredient;
        }
        return null;
    }

    @Override
    public Map<Long, Ingredient> getAllIngredients() {
            return ingredients;
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
            if (ingredients.containsKey(id)) {
                ingredients.put(id, ingredient);
                return ingredient;
            }
        return null;
    }

    @Override
    public boolean deleteIngredient(long id) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                return true;
            }
        return false;
    }
}
