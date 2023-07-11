package com.example.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String appIsRunning() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info() {
        return "Имя ученика: Колчанов Евгений\n Название проекта: Приложение для сайта рецептов\n Дата создания проекта: 11.07.2023\n Описание проекта: Проект приложения для сайта рецептов";
    }

}
