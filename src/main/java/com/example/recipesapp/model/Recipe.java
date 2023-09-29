package com.example.recipesapp.model;

import com.example.recipesapp.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private String name;

    private int cookingTime;

    private ArrayList<Ingredient> ingredients;

    private ArrayList<String> steps;
}
