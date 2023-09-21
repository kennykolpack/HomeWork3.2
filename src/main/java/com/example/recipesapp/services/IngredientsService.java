package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientsService {

    long addIngredient(Ingredient ingredient);

    Ingredient getIngredient(long id);

    Map<Long, Ingredient> getAllIngredients();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);
}
