package com.example.recipesapp.services;

public interface FilesService {
    boolean saveToFileRecipes(String json);

    String readFromFileRecipes();

    boolean saveToFileIngredients(String json);

    String readFromFileIngredients();
}
