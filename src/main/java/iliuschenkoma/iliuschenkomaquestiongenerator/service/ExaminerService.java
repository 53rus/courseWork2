package iliuschenkoma.iliuschenkomaquestiongenerator.service;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
