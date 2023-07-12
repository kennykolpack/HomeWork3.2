package com.example.recipesapp;

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
