package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.IncorrectQuestionQuantityRequestedException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> randomQuestionSet = new HashSet<>();

        if (questionService.getAll().size() < amount) {
            throw new IncorrectQuestionQuantityRequestedException();
        }
        while (randomQuestionSet.size() < amount) {
            randomQuestionSet.add(questionService.getRandomQuestion());
        }

        return randomQuestionSet;
    }

}
