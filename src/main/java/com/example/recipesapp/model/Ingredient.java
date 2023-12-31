package com.example.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {

    private String name;

    private int count;

    private String measureUnit;
}
