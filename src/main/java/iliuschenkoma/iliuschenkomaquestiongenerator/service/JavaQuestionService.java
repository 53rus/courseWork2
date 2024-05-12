package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.exception.QuestionNotFoundException;
import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questionSet = new HashSet<>(Set.of(
            new Question("Вопрос java 1", "Ответ java 1"),
            new Question("Вопрос java 2", "Ответ java 2"),
            new Question("Вопрос java 3", "Ответ java 3"),
            new Question("Вопрос java 4", "Ответ java 4"),
            new Question("Вопрос java 5", "Ответ java 5"),
            new Question("Вопрос java 6", "Ответ java 6")
    ));

    @Override
    public Question add(String question, String answer) {
        Question que = new Question(question, answer);
        return add(que);
    }

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionSet.contains(question)) {
            questionSet.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();

    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int count = random.nextInt(getAll().size());
        return getAll().stream().toList().get(count);
    }

}
