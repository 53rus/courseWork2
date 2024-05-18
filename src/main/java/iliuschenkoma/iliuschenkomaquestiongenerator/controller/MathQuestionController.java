package iliuschenkoma.iliuschenkomaquestiongenerator.controller;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.MathQuestionService;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService")
                                  QuestionService questionService) {

        this.questionService = questionService;
    }

    @GetMapping(path = "add")
    public Question addQuestion(@RequestParam("Question") String question,
                                @RequestParam("Answer") String answer) {
        return questionService.add(question,answer);
    }

    @GetMapping(path = "get")
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping(path = "remove")
    public Question removeQuestion(@RequestParam("Question") String question,
                                   @RequestParam("Answer") String answer) {
        Question que = new Question(question, answer);
        return questionService.remove(que);
    }
}
