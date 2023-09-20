package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/ingredients")
@RestController
public class IngredientController {

    private final IngredientsService ingredientsService;

    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        Ingredient ingredient = ingredientsService.getIngredient(id);
        if (ingredient == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    public ResponseEntity<Map<Long,Ingredient>> getAllIngredients() {
        Map<Long, Ingredient> ingredients = ingredientsService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient) {
        long id = ingredientsService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        Ingredient ingredient1 = ingredientsService.editIngredient(id, ingredient);
        if (ingredient1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id) {
        if (ingredientsService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
