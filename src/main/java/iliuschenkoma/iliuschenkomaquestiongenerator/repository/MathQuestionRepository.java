package iliuschenkoma.iliuschenkomaquestiongenerator.repository;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.QuestionNotFoundException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> mathQuestionSet = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {

        mathQuestionSet.add(new Question("вопрос math1 ", "ответ math1"));
        mathQuestionSet.add(new Question("вопрос math2 ", "ответ math2"));
        mathQuestionSet.add(new Question("вопрос math3 ", "ответ math3"));
        mathQuestionSet.add(new Question("вопрос math4 ", "ответ math4"));
        mathQuestionSet.add(new Question("вопрос math5 ", "ответ math5"));
        mathQuestionSet.add(new Question("вопрос math6 ", "ответ math6"));
        mathQuestionSet.add(new Question("вопрос math7 ", "ответ math7"));
    }

    @Override
    public Question add(Question question) {
        mathQuestionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (mathQuestionSet.contains(question)) {
            mathQuestionSet.remove(question);
            return question;
        }

        throw new QuestionNotFoundException();

    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(mathQuestionSet);
    }
}
