package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipesService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {

    private static long idCounter = 1;
    private final Map<Long, Recipe> recipes = new LinkedHashMap<>();

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(idCounter, recipe);
        return idCounter++;
    }

    @Override
    public Recipe getRecipe(long id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return recipe;
        }
        return null;
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public Map<Long, Recipe> getAllRecipes() {
        return recipes;
    }

    @Override
    public boolean deleteRecipe(long id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            return true;
        }
        return false;
    }
}
