package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private JavaQuestionService questionService;
    private final Question testQuestion = new Question("test", "test");

    @Test
    public void addTest() {
        when(questionRepository.add(testQuestion))
                .thenReturn(testQuestion);

        //Assertions.assertNotNull(questionService.getAll());
        Assertions.assertEquals(testQuestion, questionService.add(testQuestion));
    }

}
