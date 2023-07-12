package com.example.recipesapp.services.impl;

import com.example.recipesapp.Recipe;
import com.example.recipesapp.services.RecipesService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {

    private static long idCounter = 1;
    private final Map<Long, Recipe> recipes = new HashMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipes.put(idCounter++, recipe);
    }

    @Override
    public Map<Long, Recipe> getRecipe() {
        return recipes;
    }
}
