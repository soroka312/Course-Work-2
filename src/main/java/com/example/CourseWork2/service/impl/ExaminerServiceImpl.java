package com.example.CourseWork2.service.impl;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.exception.QuestionNotEnoughException;
import com.example.CourseWork2.service.ExaminerService;
import com.example.CourseWork2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Stream;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new QuestionNotEnoughException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .toList();
    }
}
