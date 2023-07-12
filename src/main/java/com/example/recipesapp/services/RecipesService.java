package com.example.recipesapp.services;

import com.example.recipesapp.Recipe;

import java.util.Map;

public interface RecipesService {

    Recipe addRecipe(Recipe recipe);

    Map<Long, Recipe> getRecipe();

}
