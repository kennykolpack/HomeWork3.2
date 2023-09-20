package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;
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

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipesService.getRecipe(id);
        if (recipe == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<Map<Long,Recipe>> getAllRecipes() {
        Map<Long, Recipe> recipes = recipesService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe) {
        long id = recipesService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe recipe1 = recipesService.editRecipe(id, recipe);
        if (recipe1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        if (recipesService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
