package iliuschenkoma.iliuschenkomaquestiongenerator.controller;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
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
