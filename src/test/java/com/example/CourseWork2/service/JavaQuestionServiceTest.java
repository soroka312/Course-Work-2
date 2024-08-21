package com.example.CourseWork2.service;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    void init() {
        javaQuestionService.add("Что такое конструктор в Java?",
                "Конструктор — это метод, который вызывается при создании нового объекта класса. " +
                        "Конструкторы используются для инициализации объектов. ");
        javaQuestionService.add("Что такое класс в Java?",
                "Класс — это образец для создания будущего объекта. " +
                        "Класс определяет сущность объекта: его вид, возможности, поведение.");
        javaQuestionService.add("Что такое локальные переменные?",
                "Локальные переменные находятся внутри методов или блоков кода и " +
                        "существуют только во время выполнения этих методов или блоков." +
                        " Они недоступны за пределами своего контекста выполнения.");
    }

    @AfterEach
    void clear() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void add() {
        int size = javaQuestionService.getAll().size();
        javaQuestionService.add("Как происходит загрузка апплета?",
                "Загрузка апплета включает несколько этапов:" +
                        "Загрузка HTML-страницы с тегом <applet>." +
                        "Загрузка файла .class." +
                        "Инициализация апплета через методы init(), start().");
        assertEquals(size + 1, javaQuestionService.getAll().size());
    }

    @Test
    void remove() {
        int size = javaQuestionService.getAll().size();
        javaQuestionService.remove(new Question("Что такое конструктор в Java?",
                "Конструктор — это метод, который вызывается при создании нового объекта класса. " +
                        "Конструкторы используются для инициализации объектов. "));
        assertEquals(size - 1, javaQuestionService.getAll().size());
    }

    @Test
    void getAll() {
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(3, actual.size());
    }

}
