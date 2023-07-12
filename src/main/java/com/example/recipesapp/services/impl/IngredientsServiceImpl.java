package com.example.recipesapp.services.impl;

import com.example.recipesapp.Ingredient;
import com.example.recipesapp.Recipe;
import com.example.recipesapp.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private static long idCounter = 1;
    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredients.put(idCounter++, ingredient);
    }

    @Override
    public Map<Long, Ingredient> getIngredient() {
        return ingredients;
    }
}
