package com.example.CourseWork2.service;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void init() {
        Mockito.when(questionService.getAll())
                .thenReturn(List.of(
                        new Question("Что такое конструктор в Java?",
                                "Конструктор — это метод, который вызывается при создании нового объекта класса. " +
                                        "Конструкторы используются для инициализации объектов. "),
                        new Question("Что такое класс в Java?",
                                "Класс — это образец для создания будущего объекта. " +
                                        "Класс определяет сущность объекта: его вид, возможности, поведение."),
                        new Question("Что такое локальные переменные?",
                                "Локальные переменные находятся внутри методов или блоков кода и " +
                                        "существуют только во время выполнения этих методов или блоков." +
                                        " Они недоступны за пределами своего контекста выполнения.")
                ));
    }

    @Test
    void getQuestions() {
        Collection<Question> actual = examinerService.getQuestions(3);
        Assertions.assertEquals(3,actual.size());
    }
}
