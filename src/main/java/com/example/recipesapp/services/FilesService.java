package com.example.recipesapp.services;

import com.example.recipesapp.exceptions.FailedToReadException;

import java.io.File;

public interface FilesService {
    boolean saveToFileRecipes(String json);

    String readFromFileRecipes() throws FailedToReadException;

    File getDataFileRecipes();

    File getDataFileIngredients();

    boolean cleanDataFileRecipes();

    boolean cleanDataFileIngredients();

    boolean saveToFileIngredients(String json);

    String readFromFileIngredients() throws FailedToReadException;
}
