package iliuschenkoma.iliuschenkomaquestiongenerator.controller;

import iliuschenkoma.iliuschenkomaquestiongenerator.model.Question;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.ExaminerService;
import iliuschenkoma.iliuschenkomaquestiongenerator.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "get")
    public Collection<Question> getQuestion(@RequestParam Integer amount) {
        return examinerService.getQuestion(amount);
    }

}
