package com.example.recipesapp.exceptions;

import java.io.IOException;

public class FailedToReadException extends Exception{
    public FailedToReadException() {
        super("Ошибка чтения файла");
    }
}
