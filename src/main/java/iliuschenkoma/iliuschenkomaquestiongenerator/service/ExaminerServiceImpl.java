package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.IncorrectQuestionQuantityRequestedException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> randomQuestionSet = new HashSet<>();

        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new IncorrectQuestionQuantityRequestedException();
        }
        while (randomQuestionSet.size() < amount) {
            randomQuestionSet.add(getRandomQuestion());
        }

        return randomQuestionSet;
    }

    public Question getRandomQuestion() {

        Collection<Question> mathAndJavaQuestions = new HashSet<>();

        mathAndJavaQuestions.addAll(mathQuestionService.getAll());
        mathAndJavaQuestions.addAll(javaQuestionService.getAll());

        Random random = new Random();

        int count = random.nextInt(mathAndJavaQuestions.size());
        return mathAndJavaQuestions.stream().toList().get(count);
    }

}
