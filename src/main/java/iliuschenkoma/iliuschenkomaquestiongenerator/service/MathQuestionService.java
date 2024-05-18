package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.MathQuestionRepository;
import iliuschenkoma.iliuschenkomaquestiongenerator.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class MathQuestionService implements QuestionService{

    private final MathQuestionRepository questionRepository;

    public MathQuestionService(MathQuestionRepository questionRepository) {
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
        return null;
    }
}
