package com.example.recipesapp.controllers;

import com.example.recipesapp.Ingredient;
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

    @GetMapping("/ingredients")
    public ResponseEntity<Map<Long, Ingredient>> getIngredient() {
        return ResponseEntity.ok(ingredientsService.getIngredient());
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientsService.addIngredient(ingredient));
    }
}
