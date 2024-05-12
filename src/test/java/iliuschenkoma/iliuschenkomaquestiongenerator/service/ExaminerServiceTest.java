package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.IncorrectQuestionQuantityRequestedException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ExaminerServiceTest {

    private ExaminerServiceImpl examinerService;

    private JavaQuestionService questionService;

    private final Set<Question> testSet = Set.of(
            new Question("вопрос7", "отвтет7"),
            new Question("вопрос1", "отвтет1"),
            new Question("вопрос2", "отвтет2"),
            new Question("вопрос3", "отвтет3"),
            new Question("вопрос4", "отвтет4"),
            new Question("вопрос5", "отвтет5"),
            new Question("вопрос6", "отвтет6"),
            new Question("вопрос", "отвтет")
    );

    @BeforeEach
    public void setUp() {
        questionService = Mockito.mock(JavaQuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getAll()).thenReturn(testSet);

        Collection<Question> test = examinerService.getQuestion(3);


        Assertions.assertEquals(3, test.size());
    }

    @Test
    public void IncorrectQuestionQuantityRequestedExceptionTest() {

        when(questionService.getAll()).thenReturn(testSet);

        Assertions.assertThrows(IncorrectQuestionQuantityRequestedException.class, () -> examinerService.getQuestion(77));
    }

}
