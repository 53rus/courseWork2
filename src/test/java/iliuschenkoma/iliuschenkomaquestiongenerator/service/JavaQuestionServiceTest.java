package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.QuestionNotFoundException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private JavaQuestionService questionService;
    private final Question testQuestion = new Question("test", "test");

    private final Set<Question> testSet = Set.of(
            new Question("вопрос7", "ответ7"),
            new Question("вопрос1", "ответ1"),
            new Question("вопрос2", "ответ2"),
            new Question("вопрос3", "ответ3"),
            new Question("вопрос4", "ответ4"),
            new Question("вопрос5", "ответ5"),
            new Question("вопрос6", "ответ6"),
            new Question("вопрос", "ответ"));

    @Test
    public void addTest() {
        when(questionRepository.add(testQuestion))
                .thenReturn(testQuestion);

        Assertions.assertNotNull(questionService.getAll());
        Assertions.assertEquals(testQuestion, questionService.add(testQuestion));
    }

    @Test
    public void removeTest() {
        when(questionRepository.remove(testQuestion))
                .thenReturn(testQuestion);

        Assertions.assertEquals(testQuestion, questionService.remove(testQuestion));
    }

    @Test
    public void getAllTest() {
        when(questionRepository.getAll())
                .thenReturn(testSet);

        Assertions.assertEquals(testSet, questionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        when(questionRepository.getAll()).thenReturn(testSet);
        Question actual = questionService.getRandomQuestion();
        Assertions.assertTrue(questionService.getAll().contains(actual));
    }

    @Test
    public void questionNotFoundExceptionTest() {
        when(questionRepository.remove(testQuestion))
                .thenThrow(QuestionNotFoundException.class);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> questionService.remove(testQuestion));
    }

}
