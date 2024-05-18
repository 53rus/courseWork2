package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.IncorrectQuestionQuantityRequestedException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ExaminerServiceTest {

    private ExaminerServiceImpl examinerService;

    private JavaQuestionService questionService;

    private final Set<Question> testSet = Set.of(
            new Question("вопрос7", "ответ7"),
            new Question("вопрос1", "ответ1"),
            new Question("вопрос2", "ответ2"),
            new Question("вопрос3", "ответ3"),
            new Question("вопрос4", "ответ4"),
            new Question("вопрос5", "ответ5"),
            new Question("вопрос6", "ответ6"),
            new Question("вопрос", "ответ")
    );


}
