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
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> javaQuestionSet = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {

        javaQuestionSet.add(new Question("вопрос java1 ", "ответ java1"));
        javaQuestionSet.add(new Question("вопрос java2 ", "ответ java2"));
        javaQuestionSet.add(new Question("вопрос java3 ", "ответ java3"));
        javaQuestionSet.add(new Question("вопрос java4 ", "ответ java4"));
        javaQuestionSet.add(new Question("вопрос java5 ", "ответ java5"));
        javaQuestionSet.add(new Question("вопрос java6 ", "ответ java6"));
        javaQuestionSet.add(new Question("вопрос java7 ", "ответ java7"));

    }

    @Override
    public Question add(Question question) {
        javaQuestionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestionSet.contains(question)) {
            javaQuestionSet.remove(question);
            return question;
        }

        throw new QuestionNotFoundException();

    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(javaQuestionSet);
    }
}
