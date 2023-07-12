package com.example.recipesapp.controllers;

import com.example.recipesapp.Recipe;
import com.example.recipesapp.services.RecipesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/recipes")
@RestController
public class RecipeController {

    private final RecipesService recipesService;

    public RecipeController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<Map<Long, Recipe>> getRecipe() {
        return ResponseEntity.ok(recipesService.getRecipe());
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipesService.addRecipe(recipe));
    }
}
