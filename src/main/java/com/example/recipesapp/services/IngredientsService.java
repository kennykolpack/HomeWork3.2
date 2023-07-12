package com.example.recipesapp.services;

import com.example.recipesapp.Ingredient;

import java.util.Map;

public interface IngredientsService {

    Ingredient addIngredient(Ingredient ingredient);

    Map<Long, Ingredient> getIngredient();
}
