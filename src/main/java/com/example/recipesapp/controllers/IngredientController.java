package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/ingredients")
@RestController
@Tag(name = "Ингредиенты", description = "CRUD-операции и другие эндпоинты для работы с ингредиентами")
public class IngredientController {

    private final IngredientsService ingredientsService;

    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск ингредиента по айди"
    )
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        Ingredient ingredient = ingredientsService.getIngredient(id);
        if (ingredient == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    @Operation(
            summary = "Получить список всех ингредиентов"
    )
    public ResponseEntity<Map<Long,Ingredient>> getAllIngredients() {
        Map<Long, Ingredient> ingredients = ingredientsService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping
    @Operation(
            summary = "Добавить ингредиент"
    )
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient) {
        long id = ingredientsService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Редактировать ингредиент"
    )
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        Ingredient ingredient1 = ingredientsService.editIngredient(id, ingredient);
        if (ingredient1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить ингредиент"
    )
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id) {
        if (ingredientsService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
