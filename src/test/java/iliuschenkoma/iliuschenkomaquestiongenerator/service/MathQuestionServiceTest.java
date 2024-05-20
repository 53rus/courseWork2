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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;
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

        Assertions.assertNotNull(mathQuestionService.getAll());
        Assertions.assertEquals(testQuestion, mathQuestionService.add(testQuestion));
    }

    @Test
    public void removeTest() {
        when(questionRepository.remove(testQuestion))
                .thenReturn(testQuestion);

        Assertions.assertEquals(testQuestion, mathQuestionService.remove(testQuestion));
    }

    @Test
    public void getAllTest() {
        when(questionRepository.getAll())
                .thenReturn(testSet);

        Assertions.assertEquals(testSet, mathQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {

        when(questionRepository.getAll()).thenReturn(testSet);
        Question actual = mathQuestionService.getRandomQuestion();
        Assertions.assertTrue(mathQuestionService.getAll().contains(actual));
    }


    @Test
    public void questionNotFoundExceptionTest() {
        when(questionRepository.remove(testQuestion))
                .thenThrow(QuestionNotFoundException.class);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.remove(testQuestion));
    }
}
