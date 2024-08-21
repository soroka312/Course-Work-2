package com.example.CourseWork2.service.impl;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int nextInt = random.nextInt(questions.size());
        return questions.get(nextInt);
    }
}
