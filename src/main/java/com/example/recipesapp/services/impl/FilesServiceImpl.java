package com.example.recipesapp.services.impl;

import com.example.recipesapp.services.FilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {

    @Value("${path.to.data.file.recipes}")
    private String dataFilePathRecipes;
    @Value("${name.of.data.file.recipes}")
    private String dataFileNameRecipes;
    @Value("${path.to.data.file.ingredients}")
    private String dataFilePathIngredients;
    @Value("${name.of.data.file.ingredients}")
    private String dataFileNameIngredients;

    @Override
    public boolean saveToFileRecipes(String json) {
        try {
            cleanDataFileRecipes();
            Files.writeString(Path.of(dataFilePathRecipes, dataFileNameRecipes), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFileRecipes() {
        try {
            return Files.readString(Path.of(dataFilePathRecipes, dataFileNameRecipes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cleanDataFileRecipes() {
        try {
            Path path = Path.of(dataFilePathRecipes, dataFileNameRecipes);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean saveToFileIngredients(String json) {
        try {
            cleanDataFileIngredients();
            Files.writeString(Path.of(dataFilePathIngredients, dataFileNameIngredients), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFileIngredients() {
        try {
            return Files.readString(Path.of(dataFilePathIngredients, dataFileNameIngredients));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cleanDataFileIngredients() {
        try {
            Path path = Path.of(dataFilePathIngredients, dataFileNameIngredients);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
