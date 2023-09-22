package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.FilesService;
import com.example.recipesapp.services.IngredientsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private FilesService filesService;

    private static long idCounter = 1;
    private static LinkedHashMap<Long, Ingredient> ingredients = new LinkedHashMap<>();

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    public void init() {
        readFromFileIngredients();
    }

    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(idCounter, ingredient);
        saveToFileIngredients();
        return idCounter++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null) {
         return ingredient;
        } else {
            throw new RuntimeException("Ингредиент не найден");
        }
    }

    @Override
    public Map<Long, Ingredient> getAllIngredients() {
            return ingredients;
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
            if (ingredients.containsKey(id)) {
                ingredients.put(id, ingredient);
                saveToFileIngredients();
                return ingredient;
            } else {
                throw new RuntimeException("Ингредиент не найден");
            }
    }

    @Override
    public boolean deleteIngredient(long id) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                return true;
            }
        return false;
    }

    private void saveToFileIngredients() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToFileIngredients(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFileIngredients() {
        String json = filesService.readFromFileIngredients();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
