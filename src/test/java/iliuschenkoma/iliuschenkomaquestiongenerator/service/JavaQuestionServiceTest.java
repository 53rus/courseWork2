package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.QuestionNotFoundException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

public class JavaQuestionServiceTest {

    private final QuestionService service = new JavaQuestionService();
    private final Question testQuestion = new Question("вопрос", "ответ");
    private final Question removeQuestion = new Question("вопрос", "ответ");



    @Test
    public void addQuestionTest() {

        Assertions.assertEquals(testQuestion, service.add(testQuestion));
    }

    @Test
    public void addTest() {

        Assertions.assertEquals(testQuestion, service.add("вопрос","ответ"));
    }

    @Test
    public void removeTest() {
        service.add(testQuestion);

        Assertions.assertEquals(service.remove(removeQuestion),testQuestion);
    }

    @Test
    public void questionNotFoundExceptionTest() {

        Assertions.assertThrows(QuestionNotFoundException.class, () -> service.remove(removeQuestion));
    }

    @Test
    public void getAllTest() {

        Collection<Question> testSet = service.getAll();

        Assertions.assertNotNull(testSet);
    }
}
