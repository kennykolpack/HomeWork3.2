package com.example.recipesapp.model;

import com.example.recipesapp.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Recipe {

    private String name;

    private int cookingTime;

    private ArrayList<Ingredient> ingredients;

    private ArrayList<String> steps;
}
