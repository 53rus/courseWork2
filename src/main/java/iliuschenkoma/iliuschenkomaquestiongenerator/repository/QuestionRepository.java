package iliuschenkoma.iliuschenkomaquestiongenerator.repository;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.JavaQuestionService;

import java.util.Collection;

public interface QuestionRepository {
    void init();

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

}
