package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.FilesService;
import com.example.recipesapp.services.RecipesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipesServiceImpl implements RecipesService {

    private FilesService filesService;

    private static long idCounter = 1;
    private static LinkedHashMap<Long, Recipe> recipes = new LinkedHashMap<>();

    public RecipesServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    public void init() {
        readFromFileRecipes();
    }

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(idCounter, recipe);
        saveToFileRecipes();
        return idCounter++;
    }

    @Override
    public Recipe getRecipe(long id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return recipe;
        } else {
            throw new RuntimeException("Рецепт не найден");
        }
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            saveToFileRecipes();
            return recipe;
        } else {
            throw new RuntimeException("Рецепт не найден");
        }
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
    private void saveToFileRecipes() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToFileRecipes(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFileRecipes() {
        String json = filesService.readFromFileRecipes();
        try {
            recipes = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
