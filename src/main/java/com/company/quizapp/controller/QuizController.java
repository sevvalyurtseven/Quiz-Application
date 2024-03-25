package com.company.quizapp.controller;

import com.company.quizapp.dao.QuestionDao;
import com.company.quizapp.entity.Question;
import com.company.quizapp.entity.QuestionWrapper;
import com.company.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz
    @PostMapping("/create")
    public ResponseEntity<String>createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
}
