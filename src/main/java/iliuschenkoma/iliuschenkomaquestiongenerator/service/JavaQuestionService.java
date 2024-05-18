package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.QuestionNotFoundException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.JavaQuestionRepository;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository questionRepository;

    public JavaQuestionService(JavaQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question que = new Question(question, answer);
        return add(que);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);

    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int count = random.nextInt(getAll().size());
        return getAll().stream().toList().get(count);
    }

}
