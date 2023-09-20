package com.example.recipesapp.services;

import com.example.recipesapp.model.Recipe;

import java.util.Map;

public interface RecipesService {

    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Recipe editRecipe(long id, Recipe recipe);

    Map<Long, Recipe> getAllRecipes();

    boolean deleteRecipe(long id);
}
