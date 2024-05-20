package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.IncorrectQuestionQuantityRequestedException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService javaQuestionService;
    @Mock
    private QuestionService mathQuestionService;
    @Mock
    private Random random;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaSetTest = List.of(
            new Question("java q", "java a"),
            new Question("java q1", "java a1"),
            new Question("java q2", "java q2"));

    private final List<Question> mathSetTest = List.of(
            new Question("math q", "math a"),
            new Question("math q1", "math a1"),
            new Question("math q2", "math a2"));





    @Test

    public void getQuestionTest() {
        List<Question> questionList = new ArrayList<>();
        questionList.addAll(javaSetTest);
        questionList.addAll(mathSetTest);

        when(javaQuestionService.getAll()).thenReturn(javaSetTest);
        when(javaQuestionService.getAll()).thenReturn(javaSetTest);

        Collection<Question> test = examinerService.getQuestion(2);

        Assertions.assertEquals(3, test.size());

    }


    @Test
    public void incorrectQuestionQuantityRequestedExceptionTest() {

         when(javaQuestionService.getAll()).thenReturn(javaSetTest);
         when(mathQuestionService.getAll()).thenReturn(mathSetTest);

         Assertions.assertThrows(IncorrectQuestionQuantityRequestedException.class, () -> examinerService.getQuestion(9));
    }


}
